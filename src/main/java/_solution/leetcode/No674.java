package _solution.leetcode;

import java.util.Arrays;

class No674 {

    public static void main(String[] args) {
        No674 no = new No674();
        no.findLengthOfLCIS(new int[]{1, 3, 5, 7});
    }

    public int findLengthOfLCIS(int[] nums) {
        int maxLength = Integer.MIN_VALUE;
        int l = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                l++;
            } else {
                maxLength = Math.max(maxLength, l);
                l = 1;
            }
        }
        maxLength = Math.max(maxLength, l);
        return maxLength;
    }

    public int findLengthOfLCIS2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
        }
        return Arrays.stream(dp).max().orElse(1);
    }

}

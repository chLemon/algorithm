package _solution.leetcode;

import java.util.Arrays;

class No53 {

    public static void main(String[] args) {
        No53 no = new No53();
        no.maxSubArray2(new int[]{5, 4, -1, 7, 8});
    }

    public int maxSubArray(int[] nums) {
        // 以i结尾的最大子数组和
        int[] f = new int[nums.length];
        f[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            f[i] = f[i - 1] <= 0 ? nums[i] : f[i - 1] + nums[i];
        }
        return Arrays.stream(f).max().orElse(0);
    }

    public int maxSubArray2(int[] nums) {
        int[] f = new int[nums.length + 1];
        int min = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            f[i] = f[i - 1] + nums[i - 1];
            max = Math.max(max, f[i] - min);
            min = Math.min(min, f[i]);
        }
        return max;
    }

}

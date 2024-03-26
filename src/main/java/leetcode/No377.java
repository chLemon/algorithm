package leetcode;

import java.util.Arrays;

public class No377 {


    public static void main(String[] args) {
        No377 no = new No377();
        no.combinationSum42(new int[]{1, 2, 3}, 4);
    }

    public int combinationSum4(int[] nums, int target) {
        int min = Arrays.stream(nums).min().orElse(1);
        int combineNum = target / min + 1;

        int[][] dp = new int[combineNum + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= combineNum; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 0; k < nums.length; k++) {
                    int num = nums[k];
                    if (j >= num) {
                        dp[i][j] += dp[i - 1][j - num];
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < combineNum; i++) {
            sum += dp[i][target];
        }
        return sum;
    }

    public int combinationSum42(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

}

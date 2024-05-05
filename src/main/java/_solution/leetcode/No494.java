package _solution.leetcode;

import java.util.Arrays;

class No494 {

    public static void main(String[] args) {
        No494 no = new No494();
        int res = no.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);

        System.out.println(res);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int targetDouble = sum - target;
        if (targetDouble < 0 || (targetDouble & 1) == 1) {
            return 0;
        }
        int targetSum = targetDouble / 2;

        int[][] dp = new int[nums.length][targetSum + 1];
        dp[0][0] = 1;
        if (nums[0] <= targetSum) {
            dp[0][nums[0]] += 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= targetSum; j++) {
                int x = nums[i];
                dp[i][j] = j >= x ? dp[i - 1][j - x] + dp[i - 1][j] : dp[i - 1][j];
            }
        }
        return dp[nums.length - 1][targetSum];
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int targetDouble = sum - target;
        if (targetDouble < 0 || (targetDouble & 1) == 1) {
            return 0;
        }
        int targetSum = targetDouble / 2;

        int[] dp = new int[targetSum + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (int j = targetSum; j >= x; j--) {
                dp[j] += dp[j - x];
            }
        }
        return dp[targetSum];
    }
}

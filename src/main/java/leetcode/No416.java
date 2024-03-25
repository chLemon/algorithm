package leetcode;

import java.util.Arrays;

public class No416 {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;

        int[][] dp = new int[nums.length][target + 1];
        for (int i = nums[0]; i <= target; i++) {
            dp[0][i] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = j < nums[i] ? dp[i - 1][j]
                        : Math.max(
                        dp[i - 1][j],
                        nums[i] + dp[i - 1][j - nums[i]]
                );
            }
        }
        return dp[nums.length - 1][target] == target;
    }

    // 一维数组版本
    public boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;

        int[] dp = new int[target + 1];
        for (int i = nums[0]; i <= target; i++) {
            dp[i] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= 1; j--) {
                dp[j] = j < nums[i] ? dp[j]
                        : Math.max(dp[j], nums[i] + dp[j - nums[i]]);
            }
        }
        return dp[target] == target;
    }

    // boolean 二维数组版本
    public boolean canPartition3(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                dp[i][j] = j < nums[i] ? dp[i - 1][j]
                        : dp[i - 1][j - nums[i]] || dp[i - 1][j];
            }
        }
        return dp[nums.length - 1][target];
    }

}

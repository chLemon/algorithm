package leetcode;

import java.util.Arrays;

public class No322 {

    public static void main(String[] args) {
        No322 no = new No322();
        int i = no.coinChange3(new int[]{2}, 4);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        int INF = Integer.MAX_VALUE;
        int[][] dp = new int[coins.length + 1][amount + 1];
        // init
        Arrays.fill(dp[0], INF);
        dp[0][0] = 0;
        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = j < coin ? dp[i - 1][j] : Math.min(dp[i - 1][j], (dp[i][j - coin] == INF ? INF - 1 : dp[i][j - coin]) + 1);
            }
        }
        return dp[coins.length][amount] == INF ? -1 : dp[coins.length][amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int INF = Integer.MAX_VALUE;
        int[][] dp = new int[coins.length + 1][amount + 1];
        // init
        Arrays.fill(dp[0], INF);
        dp[0][0] = 0;
        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                int tmp = dp[i - 1][j];
                for (int k = 1; k * coin <= j; k++) {
                    if (dp[i - 1][j - k * coin] != INF) {
                        tmp = Math.min(tmp, dp[i - 1][j - k * coin] + k);
                    }
                }
                dp[i][j] = tmp;
            }
        }
        return dp[coins.length][amount] == INF ? -1 : dp[coins.length][amount];
    }

    public int coinChange3(int[] coins, int amount) {
        int INF = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] != INF) dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }
}

package solutions.weeklycontest.no203;

import org.junit.Test;

public class No4 {

    public int stoneGameV(int[] stoneValue) {
//On3
        int[][] dp = new int[stoneValue.length][stoneValue.length];
        for (int i = 0; i < stoneValue.length - 1; i++) {
            dp[i][i] = 0;
            dp[i][i + 1] = Math.min(stoneValue[i], stoneValue[i + 1]);
        }
        int[] sum = new int[stoneValue.length];
        sum[0] = stoneValue[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + stoneValue[i];
        }

        for (int i = 0; i < stoneValue.length; i++) {
            for (int j = i; j < stoneValue.length; j++) {
                for (int k = i + 1; k < j; k++) {
                    int v1 = sum[k] - sum[i] + stoneValue[i];
                    int v2 = sum[j] - sum[k];
                    int temp = v1 < v2 ? dp[i][k] + v1 : dp[k + 1][j] + v2;
                    dp[i][j] = Math.max(dp[i][j], temp);
                }
            }
        }
        return dp[0][stoneValue.length - 1];
    }

    @Test
    public void test() {
        stoneGameV(new int[]{6, 2, 3, 4, 5, 5});
    }
}

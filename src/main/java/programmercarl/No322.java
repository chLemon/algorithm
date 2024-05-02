package programmercarl;

import java.util.Arrays;

class No322 {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        Arrays.fill(f[0], 0x3f3f3f);
        f[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                f[i][j] = f[i - 1][j];
                for (int k = 0; k * coin <= j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - k * coin] + k);
                }
            }
        }

        return f[n][amount] == 0x3f3f3f ? -1 : f[n][amount];
    }


    public int coinChange2(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        int INF = 0x3f3f3f;
        Arrays.fill(f, INF);
        f[0] = 0;

        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i >= coin) {
                    f[i] = Math.min(f[i], f[i - coin] + 1);
                }
            }
        }
        return f[amount] == 0x3f3f3f ? -1 : f[amount];
    }

}

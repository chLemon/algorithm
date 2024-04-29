package inf;

import java.util.Arrays;

public class No322 {

    public static void main(String[] args) {
        new No322().coinChange(new int[]{1, 2, 5}, 11);
    }

    public int coinChange(int[] coins, int amount) {
        int INF = 0x3f3f3f;
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];

        // init
        Arrays.fill(f[0], INF);
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int x = coins[i - 1];
            for (int j = 0; j < amount + 1; j++) {
                if (j < x) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - x] + 1);
                }
            }
        }
        return f[n][amount] < INF ? -1 : f[n][amount];
    }

}

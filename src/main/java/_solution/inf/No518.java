package _solution.inf;

class No518 {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];

        // init
        f[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int x = coins[i - 1];
            for (int j = 0; j < amount + 1; j++) {
                if (j < x) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - x];
                }
            }
        }
        return f[n][amount];
    }

}

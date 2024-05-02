package programmercarl;

class No518 {

    public static void main(String[] args) {
        System.out.println(new No518().change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        f[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int x = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
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

package _solution.programmercarl;

class No309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][2];
        f[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            int x = prices[i];
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + x);
            if (i == 1) {
                f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - x);
            } else {
                f[i][1] = Math.max(f[i - 1][1], f[i - 2][0] - x);
            }
        }
        return f[n - 1][0];
    }

}

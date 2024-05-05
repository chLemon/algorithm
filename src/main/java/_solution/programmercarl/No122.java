package _solution.programmercarl;

class No122 {

    public int maxProfit(int[] prices) {
        int n = prices.length;

        // f(i)(0/1) 表示 第i天晚上，持有1 / 未持有0 股票时的最大利润
        int[][] f = new int[n][2];
        f[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            int x = prices[i];
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + x);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - x);
        }
        return f[n - 1][0];
    }

}

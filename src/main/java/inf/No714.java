package inf;

class No714 {

    public int maxProfit(int[] prices, int fee) {
        // 卖出交手续费
        int n = prices.length;
        //  f[i][0/1] 表示 在第i天结束时，持有1 / 未持有0 时的最大利润
        int[][] f = new int[n][2];
        f[0][0] = 0;
        f[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            int x = prices[i];
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + x - fee);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - x);
        }
        return f[n - 1][0];
    }

}

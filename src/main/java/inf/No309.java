package inf;

class No309 {

    public static void main(String[] args) {
        new No309().maxProfit(new int[]{1, 2, 4});
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 定义 f[i][0/1] 表示 第i天结束时，持有1 / 未持有0 的情况下，利润的最大值
        int[][] f = new int[n][2];
        f[0][0] = 0;
        f[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            int x = prices[i];
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + x);
            // 由于卖出股票的第二天不能买入股票。所以今天如果持有股票，只可能是从前天未持有的状态转移而来：
            // 前天卖出昨天冷冻 / 前天就未持有，昨天依旧未持有
            // i - 2 < 0 时，昨天是第一天，今天持有，昨天未持有今天买入 / 昨天买入今天不变
            f[i][1] = Math.max(f[i - 1][1],
                    (i - 2 < 0 ? f[i - 1][0] : f[i - 2][0]) - x);
        }

        return f[n - 1][0];
    }

}

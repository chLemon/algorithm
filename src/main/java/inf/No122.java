package inf;

public class No122 {


    public int maxProfit(int[] prices) {
        // 定义 f[i][0/1] 表示，在f[i]天结束的时候，手中 不持有0 / 持有1 股票时，能获得的最大利润
        int n = prices.length;
        int[][] f = new int[n][2];
        f[0][0] = 0;
        f[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            // 未持有 <-- 未持有 / 持有
            int x = prices[i];
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + x);
            f[i][1] = Math.max(f[i - 1][0] - x, f[i - 1][1]);
        }

        return f[n - 1][0];
    }

}

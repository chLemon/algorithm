package _solution.leetcode;

class No121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;

        for (int price : prices) {
            min = Math.min(price, min);
            res = Math.max(price - min, res);
        }
        return res;
    }

    // dp练习
    public int maxProfit2(int[] prices) {
        // 定义dp[i][j]，i表示在0-i天，j只取值0/1，表示是否持有股票，dp[i][j]表示最大利润
        int[][] dp = new int[prices.length + 1][2];
        // dp[i][0]，表示今天不持股，要不是因为昨天不持股，要么卖掉昨天的持股 = Max( dp[i-1][0] , dp[i-1][1] + prices[i])
        // dp[i][1]，表示今天持股，要么是昨天持股，要么是昨天不持股，今天买入。由于只能买卖一次，买入时候清空前面的影响
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

}

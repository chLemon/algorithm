package _solution.leetcode;

class No123 {

    public static void main(String[] args) {
        No123 no = new No123();
        int i = no.maxProfit(new int[]{3, 2, 6, 5, 0, 3});
        // 7
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][4];
        int INF = 0x3f3f3f;

        // 第零天，所有都不可买
        for (int i = 0; i < 4; i++) {
            dp[0][i] = -INF;
        }
        for (int i = 1; i <= prices.length; i++) {
            // 今天处于第一次买入
            int price = prices[i - 1];
            dp[i][0] = Math.max(dp[i - 1][0], -price);
            // 今天处于第一次卖出后
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + price);
            // 今天处于第二次买入
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - price);
            // 今天处于第二次卖出
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + price);
        }
        int res = Math.max(dp[prices.length - 1][1], dp[prices.length - 1][3]);
        return Math.max(res, 0);
    }

}

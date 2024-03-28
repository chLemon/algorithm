package leetcode;

public class No123 {

    public static void main(String[] args) {
        No123 no = new No123();
        int i = no.maxProfit(new int[]{2, 1, 4, 5, 2, 9, 7});
        // 11
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        int INF = 0x3f3f3f;

        // 第一天买入
        dp[0][0] = -prices[0];
        dp[0][1] = -INF;
        dp[0][2] = -INF;
        dp[0][3] = -INF;

        for (int i = 1; i < prices.length; i++) {
            // 今天处于第一次买入
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 今天处于第一次卖出后
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            // 今天处于第二次买入
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            // 今天处于第二次卖出
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        int res = Math.max(dp[prices.length - 1][1], dp[prices.length - 1][3]);
        return Math.max(res, 0);
    }


}

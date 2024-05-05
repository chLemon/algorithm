package _solution.leetcode;

class No714 {

    public int maxProfit(int[] prices, int fee) {
        int[][] f = new int[prices.length + 1][2];
        f[0][1] = -0x3f3f3f;

        for (int i = 1; i <= prices.length; i++) {
            int price = prices[i - 1];
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + price - fee);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - price);
        }

        int max = Math.max(f[prices.length][0], f[prices.length][1]);
        return Math.max(max, 0);
    }

}

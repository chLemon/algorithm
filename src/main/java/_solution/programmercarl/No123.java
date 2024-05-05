package _solution.programmercarl;

class No123 {

    public static void main(String[] args) {
        new No123().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // f[i][k][0/1] 在第i天结束时，操作k次，持有/未持有股票的最大利润
        // 操作次数在 卖出 时减去
        int[][][] f = new int[n][3][2];
        for (int k = 0; k < 3; k++) {
            f[0][k][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            int x = prices[i];
            for (int k = 0; k < 3; k++) {
                if (k - 1 < 0) {
                    f[i][k][0] = f[i - 1][k][0];
                } else {
                    f[i][k][0] = Math.max(f[i - 1][k][0], f[i - 1][k - 1][1] + x);
                }
                f[i][k][1] = Math.max(f[i - 1][k][1], f[i - 1][k][0] - x);
            }
        }
        return f[n - 1][2][0];
    }

}

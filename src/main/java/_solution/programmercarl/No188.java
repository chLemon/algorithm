package _solution.programmercarl;

class No188 {

    public static void main(String[] args) {
        System.out.println(new No188().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // f[i][k][0/1] 在第i天结束时，操作k次，持有/未持有股票的最大利润
        // 操作次数在 卖出 时减去
        int[][][] f = new int[n][k + 1][2];
        for (int i = 0; i < k + 1; i++) {
            f[0][i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            int x = prices[i];
            for (int l = 0; l < k + 1; l++) {
                if (l == 0) {
                    f[i][0][0] = f[i - 1][0][0];
                } else {
                    f[i][l][0] = Math.max(f[i - 1][l][0], f[i - 1][l - 1][1] + x);
                }
                f[i][l][1] = Math.max(f[i - 1][l][1], f[i - 1][l][0] - x);
            }
        }
        return f[n - 1][k][0];
    }

}

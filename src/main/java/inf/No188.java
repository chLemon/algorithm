package inf;

class No188 {

    public static void main(String[] args) {
        new No188().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int INF = 0x3f3f3f;

        // f[i][k][0/1] 表示，在第i天结束，操作了k笔，持有1 / 未持有0 时的利润
        int[][][] f = new int[n][k + 1][2];

        // init，买的时候扣减次数
        // 第0天，任意次操作下，未持有的利润都是0；持有在1-k次的时候为-prices，0次为-INF
        // 在任意天，0次操作情况下，未持有利润为0；持有都是-INF
        for (int i = 1; i < k + 1; i++) {
            f[0][i][1] = -prices[0];
        }
        for (int i = 0; i < n; i++) {
            f[i][0][1] = -INF;
        }
        for (int i = 1; i < n; i++) {
            int x = prices[i];
            for (int j = 1; j <= k; j++) {
                f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + x);
                f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - x);
            }
        }
        return f[n - 1][k][0];
    }

}

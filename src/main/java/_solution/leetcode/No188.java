package _solution.leetcode;

class No188 {

    public static void main(String[] args) {
        No188 no = new No188();
        int a = no.maxProfit(2, new int[]{1});
        System.out.println(a);
    }

    public int maxProfit(int k, int[] prices) {
        int totalStatusCount = 2 * k;
        int[][] f = new int[totalStatusCount][prices.length + 1];

        int INF = 0x3f3f3f;
        for (int i = 0; i < totalStatusCount; i++) {
            f[i][0] = -INF;
        }

        for (int i = 1; i <= prices.length; i++) {
            int price = prices[i - 1];
            for (int j = 0; j < totalStatusCount; j++) {
                if ((j & 1) == 0) {
                    // 持有状态
                    f[j][i] = Math.max(f[j][i - 1], (j < 1 ? 0 : f[j - 1][i - 1]) - price);
                } else {
                    // 卖出状态
                    f[j][i] = Math.max(f[j][i - 1], f[j - 1][i - 1] + price);
                }
            }
        }
        int max = -INF;
        for (int i = 0; i < totalStatusCount; i++) {
            max = Math.max(f[i][prices.length], max);
        }
        return Math.max(max, 0);
    }

}

package leetcode;

import java.util.Arrays;

public class No309 {

    public static void main(String[] args) {
        No309 no = new No309();
        int i = no.maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int[][] f = new int[prices.length + 1][3];

        int INF = 0X3f3f3f;
        Arrays.fill(f[0], -INF);
        f[0][2] = 0;

        for (int i = 1; i < prices.length + 1; i++) {
            int price = prices[i - 1];
            // 持有
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - price);
            // 不持有、冷冻
            f[i][1] = f[i - 1][0] + price;
            // 不持有、解冻
            f[i][2] = Math.max(f[i - 1][2], f[i - 1][1]);
        }
        int max = Arrays.stream(f[prices.length]).max().orElse(0);

        return Math.max(max, 0);
    }

}

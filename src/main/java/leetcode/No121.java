package leetcode;

public class No121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;

        for (int price : prices) {
            min = Math.min(price, min);
            res = Math.max(price - min, res);
        }
        return res;
    }

}

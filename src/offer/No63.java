package offer;

public class No63 {
    /*
    假设把某股票的价格按照时间先后顺序存储在数组中，
    请问买卖该股票一次可能获得的最大利润是多少？
     */
    public int maxProfit(int[] prices) {
        if (prices.length<2){
            return 0;
        }
        int result = 0;
        int min = prices[0];
        int max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int t = prices[i];
            if (t<min){
                min=t;
                max=t;
                continue;
            }
            if (t>max){
                max=t;
            }
            if ((max-min)>result){
                result=max-min;
            }
        }
        return result;

        /*
        动态规划思路
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
         */
    }
}

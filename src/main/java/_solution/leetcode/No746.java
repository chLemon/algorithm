package _solution.leetcode;

class No746 {

    public static void main(String[] args) {
        No746 no = new No746();
        int i = no.minCostClimbingStairs(new int[]{10, 15, 20});
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int lastLast = 0;
        int last = 0;
        int res = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            res = Math.min(lastLast + cost[i - 2], last + cost[i - 1]);
            lastLast = last;
            last = res;
        }
        return res;
    }

}

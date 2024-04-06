package leetcode;

class No343 {

    public static void main(String[] args) {
        No343 no = new No343();
        no.integerBreak(10);
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            // 求dp[i]
            for (int j = 1; j < i - 1; j++) {
                int tmp = Math.max(j * dp[i - j], j * (i - j));
                dp[i] = Math.max(dp[i], tmp);
            }
        }
        return dp[n];
    }

}

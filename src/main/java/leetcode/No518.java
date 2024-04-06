package leetcode;

class No518 {

    public static void main(String[] args) {
        No518 no = new No518();
        int i = no.change(5, new int[]{1, 2, 5});
        System.out.println(i);
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            int c = coins[i];
            for (int j = c; j <= amount; j++) {
                dp[j] += dp[j - c];
            }
        }
        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = j < coin ? dp[i - 1][j] : dp[i - 1][j] + dp[i][j - coin];
            }
        }
        return dp[coins.length][amount];
    }

}

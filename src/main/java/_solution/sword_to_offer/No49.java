package _solution.sword_to_offer;

class No49 {
    /*
    我们把只包含质因子 2、3 和 5
    的数称作丑数（Ugly Number）。
    求按从小到大的顺序的第 n 个丑数。
     */

    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        int i = 1;
        while (i < n) {
            dp[i] = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
            if (dp[i] == dp[a] * 2) {
                a++;
            }
            if (dp[i] == dp[b] * 3) {
                b++;
            }
            if (dp[i] == dp[c] * 5) {
                c++;
            }
            i++;
        }
        return dp[n - 1];

//        int a = 0, b = 0, c = 0;
//        int[] dp = new int[n];
//        dp[0] = 1;
//        for(int i = 1; i < n; i++) {
//            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
//            dp[i] = Math.min(Math.min(n2, n3), n5);
//            if(dp[i] == n2) a++;
//            if(dp[i] == n3) b++;
//            if(dp[i] == n5) c++;
//        }
//        return dp[n - 1];

    }

}

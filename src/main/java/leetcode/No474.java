package leetcode;

class No474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[] strs0Count = new int[strs.length];
        int[] strs1Count = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            int c0 = 0;
            int c1 = 0;
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    c1++;
                } else {
                    c0++;
                }
            }
            strs0Count[i] = c0;
            strs1Count[i] = c1;
        }


        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int c0 = strs0Count[i - 1];
            int c1 = strs1Count[i - 1];
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    dp[i][j][k] = j < c0 || k < c1 ? dp[i - 1][j][k] : Math.max(dp[i - 1][j][k], 1 + dp[i - 1][j - c0][k - c1]);
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[] strs0Count = new int[strs.length];
        int[] strs1Count = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            int c0 = 0;
            int c1 = 0;
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    c1++;
                } else {
                    c0++;
                }
            }
            strs0Count[i] = c0;
            strs1Count[i] = c1;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int c0 = strs0Count[i];
            int c1 = strs1Count[i];
            for (int j = m; j >= c0; j--) {
                for (int k = n; k >= c1; k--) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - c0][k - c1]);
                }
            }
        }

        return dp[m][n];
    }
}

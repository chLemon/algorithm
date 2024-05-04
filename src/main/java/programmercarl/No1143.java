package programmercarl;

public class No1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] f = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    f[i][j] = 1 + f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
                max = Math.max(max, f[i][j]);
            }
        }
        return max;
    }

}

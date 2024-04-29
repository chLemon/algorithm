package inf;

import java.util.Arrays;

public class No1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        /*
        如果末尾字符一样。 f[i][j] = f[i-1][j-1] + 1
        如果不一样，f[i][j] = Math.max(i-1 , j-1 )
         */
        int m = text1.length();
        int n = text2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
            System.out.println(Arrays.toString(f[i]));
        }
        return f[m][n];
    }

}

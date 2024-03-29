package leetcode;

public class No516 {

    public int longestPalindromeSubseq(String s) {
        int[][] f = new int[s.length()][s.length()];

        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        f[i][j] = 1;
                    } else if (j - i == 1) {
                        f[i][j] = 2;
                    } else {
                        f[i][j] = f[i + 1][j - 1] + 2;
                    }
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][s.length() - 1];
    }

}
 
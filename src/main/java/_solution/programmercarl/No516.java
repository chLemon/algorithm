package _solution.programmercarl;

class No516 {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        f[i][j] = 1;
                    } else if (j - i == 1) {
                        f[i][j] = 2;
                    } else {
                        f[i][j] = f[i + 1][j - 1] + 2;
                    }
                } else {
                    f[i][j] = Math.max(f[i][j - 1], f[i + 1][j]);
                }
            }
        }

        return f[0][n - 1];
    }

}

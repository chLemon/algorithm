package _solution.programmercarl;

class No115 {

    public int numDistinct(String s, String t) {
        // 重点：选和不选 都是合法答案

        int m = s.length();
        int n = t.length();
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    continue;
                }
                if (s.charAt(i) == t.charAt(j)) {
                    if (i == j) {
                        f[i][j] = 1;
                    } else {
                        f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                    }
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }

        }

        return f[m - 1][n - 1];
    }

}

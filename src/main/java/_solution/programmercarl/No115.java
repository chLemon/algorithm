package _solution.programmercarl;

class No115 {

    public int numDistinct(String s, String t) {
        // 从s里选t，相等时，可以选，也可以不选，都是一种可能的方式

        int m = s.length();
        int n = t.length();
        int[][] f = new int[m + 1][n + 1];

        // s为空，t不空，0，无答案
        // s不空，t空，1，表示这种情况可以
        for (int i = 0; i < m + 1; i++) {
            f[i][0] = 1;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i < j) {
                    continue;
                }
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }

        }

        return f[m][n];
    }

}

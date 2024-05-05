package _solution.inf;

class No516 {

    public int longestPalindromeSubseq(String s) {
        // 定义 f[i][j] 为 i开始，j结尾的串里的 最长子序列长度
        int n = s.length();
        int[][] f = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    f[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = 2 + f[i + 1][j - 1];  // i是从i+1转换来的，所以i得倒叙
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }

        return f[0][n - 1];
    }

}

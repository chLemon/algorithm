package _solution.leetcode;

class No5 {

    public static void main(String[] args) {
        No5 no = new No5();
    }

    // 如果这道题是求长度的话
    public int longestPalindromeLength(String s) {
        int[][] f = new int[s.length()][s.length()];

        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (j - i == 0) {
                    f[i][j] = 1;
                } else if (j - i == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        f[i][j] = 2;
                    } else {
                        f[i][j] = 1;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        f[i][j] = f[i + 1][j - 1] + 2;
                    } else {
                        f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                    }
                }
            }
        }
        return f[0][s.length() - 1];
    }

}

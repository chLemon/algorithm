package _solution.leetcode;

class No5 {

    public static void main(String[] args) {
        No5 no = new No5();
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        int left = 0;
        int right = 0;
        // [i, j]
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    f[i][j] = true;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        f[i][j] = i + 1 == j ? true : f[i + 1][j - 1];
                    }
                }
                if (f[i][j] && j - i > right - left) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

}

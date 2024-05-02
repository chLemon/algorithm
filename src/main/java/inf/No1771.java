package inf;

public class No1771 {
    public static void main(String[] args) {
        new No1771().longestPalindrome("cacb", "cbba");
    }

    public int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        int n = s.length();
        int[][] f = new int[n][n];

        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    f[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = 2 + f[i + 1][j - 1];
                    if (i < word1.length() && j >= word1.length()) {
                        ans = Math.max(ans, f[i][j]);
                    }
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }

            }
        }
        return ans;

    }

}

package _solution.leetcode;

class No1143 {

    public static void main(String[] args) {
        No1143 no = new No1143();
        int i = no.longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] f = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 != c2) {
                    f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]);
                } else {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
            }
        }
        return f[text1.length()][text2.length()];
    }

}

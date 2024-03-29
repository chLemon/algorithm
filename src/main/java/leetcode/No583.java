package leetcode;

public class No583 {

    public int minDistance(String word1, String word2) {
        int[][] f = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                f[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? f[i - 1][j - 1] + 1 : Math.max(f[i - 1][j], f[i][j - 1]);
            }
        }
        int maxSub = f[word1.length()][word2.length()];
        return word1.length() + word2.length() - 2 * maxSub;
    }

}

package _solution.leetcode;

class No392 {

    public boolean isSubsequence(String s, String t) {
        int si = 0;
        int ti = 0;
        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
                ti++;
            } else {
                ti++;
            }
        }
        return si == s.length();
    }

    // 思考题
    public boolean isSubsequence2(String s, String t) {
        // 制作一个表
        int m = t.length();
        // 从位置 i 开始，下一个字母出现的位置
        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = -1;   // 最后一个位置，-1表示非法
        }
        for (int i = m - 1; i >= 0; i--) {
            int tc = t.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if (j == tc) {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }

        // 判断
        int tIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int sc = s.charAt(i) - 'a';
            int nextMatchIndex = f[tIndex][sc];
            if (nextMatchIndex == -1) return false;
            tIndex = nextMatchIndex + 1;
        }
        return true;
    }

}

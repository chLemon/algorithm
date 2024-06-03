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

    public boolean isSubsequence2(String s, String t) {
        // t 预处理
        int[][] f = new int[t.length() + 1][26];
        // i适配后，下一个字母在哪里出现
        
        
    }

}

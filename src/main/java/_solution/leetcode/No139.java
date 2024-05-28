package _solution.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class No139 {

    int[] memory;

    public static void main(String[] args) {
        No139 no = new No139();
        no.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aa"));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        // [0,i)
        // [j, i)
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (wordSet.contains(s.substring(j, i))) {
                    f[i] = f[j];
                }
                if (f[i]) break;
            }
        }
        return f[n];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length()) f[i] = f[i] || (f[i - word.length()] && s.startsWith(word, i - word.length()));
                if (f[i]) break;
            }
        }
        return f[s.length()];
    }



}

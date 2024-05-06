package _solution.programmercarl;

import java.util.Arrays;
import java.util.List;

class No139 {

    public static void main(String[] args) {
        No139 no = new No139();
        no.wordBreak("leeftcode", Arrays.asList("leet", "code"));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                if (f[i]) break;
                if (i >= word.length()) {
                    f[i] = f[i - word.length()] && word.equals(s.substring(i - word.length(), i));
                }
            }
        }
        return f[n];
    }

}

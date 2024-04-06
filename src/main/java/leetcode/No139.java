package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class No139 {

    int[] memory;

    public static void main(String[] args) {
        No139 no = new No139();
        no.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aa"));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int minLength = wordDict.stream().mapToInt(String::length).min().orElse(1);
        int totalCount = s.length() / minLength + 1;

        boolean[][] f = new boolean[totalCount + 1][s.length() + 1];
        f[0][0] = true;
        for (int i = 1; i <= totalCount; i++) {
            for (int j = 0; j <= s.length(); j++) {
                f[i][j] = f[i - 1][j];
                for (String word : wordDict) {
                    if (j >= word.length())
                        f[i][j] = f[i][j] || (f[i - 1][j - word.length()] && s.startsWith(word, j - word.length()));
                    if (f[i][j]) break;
                }
            }
        }
        return f[totalCount][s.length()];
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

    public boolean wordBreak3(String s, List<String> wordDict) {
        Map<Character, List<String>> firstChar2Words = wordDict.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));
        memory = new int[s.length()];
        return backTracing(s, firstChar2Words, 0);
    }

    private boolean backTracing(String s, Map<Character, List<String>> firstChar2Words, int index) {
        if (index >= s.length()) {
            return true;
        }
        if (memory[index] != 0) {
            return memory[index] == 1;
        }
        // 从index看有没有能匹配的
        char startChar = s.charAt(index);
        List<String> words = firstChar2Words.get(startChar);
        if (words == null || words.isEmpty()) {
            memory[index] = -1;
            return false;
        }
        // 有首字母匹配的，开始匹配
        for (String word : words) {
            if (match(s, index, word)) {
                // 当前字母匹配，继续往下匹配
                boolean nextRes = backTracing(s, firstChar2Words, index + word.length());
                if (nextRes) {
                    memory[index] = 1;
                    return true;  // 如果剩下的都匹配成功
                }
            }
        }
        memory[index] = -1;
        return false;
    }

    private boolean match(String s, int sIndex, String word) {
        if (s.length() - sIndex < word.length()) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (s.charAt(sIndex + i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

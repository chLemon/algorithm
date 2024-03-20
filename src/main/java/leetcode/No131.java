package leetcode;

import java.util.ArrayList;
import java.util.List;

public class No131 {

    boolean[][] palindromeRes;

    public static void main(String[] args) {
        No131 no = new No131();
        List<List<String>> aab = no.partition("aab");
        System.out.println(aab);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        initPalindromeRes(s);

        backTracing(s, 0, res, path);
        return res;
    }

    private void initPalindromeRes(String s) {
        palindromeRes = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            palindromeRes[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            palindromeRes[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        // s[i] == s[j] && s[i+1, j-1]
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {

            }
        }
        // todo cwj 这里之后回来再看
        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                palindromeRes[i][j] = palindromeRes[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }
    }

    private void backTracing(String s, Integer start, List<List<String>> res, List<String> path) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (!isPalindrome(start, i)) {
                continue;
            }
            path.add(s.substring(start, i));
            backTracing(s, i, res, path);
            path.remove(path.size() - 1);
        }
    }

    // todo 这里还有错
    private boolean isPalindrome(int start, int end) {
        if (start >= end) {
            return false;
        }

        return palindromeRes[start - 1][end - 1];
    }

}

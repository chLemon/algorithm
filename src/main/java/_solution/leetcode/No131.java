package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

class No131 {

    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    // [i, j] 是否为回文串
    boolean[][] isPalindrome;

    public static void main(String[] args) {
        No131 no = new No131();
        no.partition("aab");
    }

    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        isPalindrome = new boolean[chars.length][chars.length];
        initIsPalindrome(chars);

        backtracking(s, 0);
        return result;
    }

    public void backtracking(String str, int startIndex) {
        if (startIndex >= str.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < str.length(); i++) {
            if (isPalindrome[startIndex][i]) {
                path.add(str.substring(startIndex, i + 1));
                backtracking(str, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public void initIsPalindrome(char[] chars) {
        // 对角线都是true
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) {
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                }
            }
        }
    }

}

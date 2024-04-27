package inf;

import java.util.ArrayList;
import java.util.List;

public class No17 {


    String[] words = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        char[] path = new char[digits.length()];

        dfs(digits, 0, path);

        return res;
    }

    private void dfs(String digits, int i, char[] path) {
        if (i == digits.length()) {
            res.add(new String(path));
            return;
        }

        String word = words[digits.charAt(i) - '0'];
        for (int j = 0; j < word.length(); j++) {
            path[i] = word.charAt(j);
            dfs(digits, i + 1, path);
        }
    }

}

package inf;

import java.util.ArrayList;
import java.util.List;

public class No131 {

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        // 选几个
        dfs(0);

        return res;
    }

    private void dfs(int i) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j)) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int left, int right) {
        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        return true;
    }

}

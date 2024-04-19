package programmercarl;

import java.util.ArrayList;
import java.util.List;

class No131 {

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) {
                continue;
            }
            path.add(s.substring(start, i + 1));
            dfs(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}

package _solution.programmercarl;

import java.util.ArrayList;
import java.util.List;

class No93 {

    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start) {
        if (path.size() == 4) {
            if (start == s.length()) {
                res.add(String.join(".", path));
            }
            return;
        }

        // 1 2 3
        for (int i = 1; i <= 3; i++) {
            if (s.length() - start - i < 3 - path.size()) break;
            if (s.charAt(start) == '0' && i > 1) {
                break;
            }
            if (i == 3 && Integer.parseInt(s.substring(start, start + i)) > 255) {
                break;
            }
            path.add(s.substring(start, start + i));
            dfs(s, start + i);
            path.remove(path.size() - 1);
        }
    }
    
    /*
        if (start >= s.length() && path.size() == 4) {
            res.add(String.join(".", path));
            return;
        }

        for (int i = start + 1; i <= start + 3 && i <= s.length(); i++) {
            if (s.length() - i > (3 - path.size()) * 3) {
                continue;
            }
            String split = s.substring(start, i);
            if (isValid(split)) {
                path.add(split);
                backTracing(s, i);
                path.remove(path.size() - 1);
            }
        }
     */

}

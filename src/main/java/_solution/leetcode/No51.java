package _solution.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class No51 {

    List<List<String>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        No51 no = new No51();
        List<List<String>> res = no.solveNQueens(4);
        System.out.println(res);
    }

    public List<List<String>> solveNQueens(int n) {
        backTracing(n, 0);
        return res;
    }

    private void backTracing(int n, int layer) {
        if (layer == n) {
            res.add(transfer(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (conflict(i, layer)) {
                continue;
            }
            path.add(i);
            backTracing(n, layer + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean conflict(int x, int y) {
        for (int i = 0; i < path.size(); i++) {
            Integer j = path.get(i);
            if (conflict(j, i, x, y)) {
                return true;
            }
        }
        return false;
    }

    private boolean conflict(int x1, int y1, int x2, int y2) {
        return x1 == x2 || Math.abs(x2 - x1) == Math.abs(y2 - y1);
    }

    private List<String> transfer(List<Integer> path) {
        List<String> res = new ArrayList<>();
        for (Integer y : path) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < y; i++) {
                line.append(".");
            }
            line.append("Q");
            for (int i = 0; i < path.size() - 1 - y; i++) {
                line.append(".");
            }
            res.add(line.toString());
        }
        return res;
    }

    private List<String> transfer2(List<Integer> path) {
        List<String> res = new ArrayList<>();
        for (Integer y : path) {
            char[] chars = new char[path.size()];
            Arrays.fill(chars, '.');
            chars[y] = 'Q';
            res.add(new String(chars));
        }
        return res;
    }

}

package _solution.inf;

import java.util.ArrayList;
import java.util.List;

class No77 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;
    int k;

    public static void main(String[] args) {
        new No77().combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
//        dfs(1);

        dfs2(1);
        return res;
    }

    private void dfs2(int i) {
        if (path.size() >= k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 还要选的数字个数 k - path.size()
        // 还能选的数字个数 n - i + 1
        if (k - path.size() > n - i + 1) {
            return;
        }

        // 每个数字可以选也可以不选
        // 不选当前数字
        dfs2(i + 1);

        // 选当前数字
        path.add(i);
        dfs2(i + 1);
        path.remove(path.size() - 1);
    }

    private void dfs(int i) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 还能选的数字个数 n - i + 1
        // 还要选的数字个数 k - path.size()
        if (n - i + 1 < k - path.size()) {
            return;
        }

        for (int j = i; j <= n; j++) {
            path.add(j);
            dfs(j + 1);
            path.remove(path.size() - 1);
        }
    }

}

package _solution.programmercarl;

import java.util.ArrayList;
import java.util.List;

class No77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        dfs(n, k, path, res, 1);
        return res;
    }

    private void dfs(int n, int k, List<Integer> path, List<List<Integer>> res, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            // k 包括当前值，还需要填的数，k =1 i = n是可以的
            // 可以优化
            path.add(i);
            dfs(n, k - 1, path, res, i + 1);
            path.remove(path.size() - 1);
        }
    }

}

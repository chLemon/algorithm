package _solution.programmercarl;

import java.util.ArrayList;
import java.util.List;

class No39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(path, res, candidates, target, 0, 0);

        return res;
    }

    private void dfs(List<Integer> path, List<List<Integer>> res, int[] candidates, int target, int i, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (sum + candidates[j] > target) {
                break;
            }
            path.add(candidates[j]);
            dfs(path, res, candidates, target, j, sum + candidates[j]);
            path.remove(path.size() - 1);
        }
    }

}

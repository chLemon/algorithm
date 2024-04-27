package inf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No39 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;

        dfs(0, target);

        return res;
    }

    private void dfs(int i, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (j > 0 && candidates[j] == candidates[j - 1]) {
                continue;
            }
            int candidate = candidates[j];
            path.add(candidate);
            dfs(j, target - candidate);
            path.remove(path.size() - 1);
        }
    }

}

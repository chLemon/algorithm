package programmercarl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class No40 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] candidates;
    int target;

    public static void main(String[] args) {
        No40 no = new No40();
        System.out.println(no.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        this.candidates = candidates;
        this.target = target;

        dfs(0, 0);

        return res;
    }

    private void dfs(int start, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            dfs(i + 1, sum + candidates[i]);
            path.remove(path.size() - 1);
        }
    }

}

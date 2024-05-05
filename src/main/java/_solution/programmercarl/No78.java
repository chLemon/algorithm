package _solution.programmercarl;

import java.util.ArrayList;
import java.util.List;

class No78 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));

            dfs(nums, i + 1);

            path.remove(path.size() - 1);
        }
    }

}

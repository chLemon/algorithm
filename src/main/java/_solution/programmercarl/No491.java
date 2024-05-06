package _solution.programmercarl;

import domain.TreeNode;
import java.util.ArrayList;
import java.util.List;

class No491 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        dfs(0);

        return res;
    }

    private void dfs(int start) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }

        boolean[] used = new boolean[201];
        for (int i = start; i < nums.length; i++) {
            if (used[nums[i] + 100]) continue;
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) continue;

            path.add(nums[i]);
            used[100 + nums[i]] = true;
            dfs(i + 1);
            path.remove(path.size() - 1);
        }
    }

}

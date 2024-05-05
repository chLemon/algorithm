package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

class No46 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backTracing(nums, used);
        return res;
    }

    private void backTracing(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;

            backTracing(nums, used);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

}

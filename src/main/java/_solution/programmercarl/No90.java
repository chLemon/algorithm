package _solution.programmercarl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class No90 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;

        dfs(0);

        return res;
    }

    private void dfs(int start) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            dfs(i + 1);
            path.remove(path.size() - 1);
        }
    }

}

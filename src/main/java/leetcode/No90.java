package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class No90 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTracing(nums, 0);
        return res;
    }

    private void backTracing(int[] nums, int start) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backTracing(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}

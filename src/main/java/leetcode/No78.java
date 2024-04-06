package leetcode;

import java.util.ArrayList;
import java.util.List;

class No78 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTracing(nums, 0);
        return res;
    }

    private void backTracing(int[] nums, int start) {
        if (start <= nums.length) { // 终止条件可以不加
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backTracing(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }


}

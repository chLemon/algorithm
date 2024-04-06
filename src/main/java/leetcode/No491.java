package leetcode;

import java.util.ArrayList;
import java.util.List;

class No491 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracing(nums, 0);
        return res;
    }

    private void backTracing(int[] nums, int start) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
//        Set<Integer> set = new HashSet<>(); 
        int[] used = new int[201]; // 数据有限，可以直接用数组来做hash
        for (int i = start; i < nums.length; i++) {
            if (used[nums[i] + 100] == 1) {
                continue;
            }
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                used[nums[i] + 100] = 1;
//                set.add(nums[i]);
                backTracing(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

}

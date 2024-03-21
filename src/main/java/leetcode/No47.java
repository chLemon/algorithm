package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No47 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];

        backTracing(nums);

        return res;
    }

    private void backTracing(int[] nums) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        Set<Integer> set = new HashSet<>();
        // 或者排序后，用 i > 0 && n[i] == n[i-1] && used[i-1] == false 效率更高
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || set.contains(nums[i])) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            set.add(nums[i]);

            backTracing(nums);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

}

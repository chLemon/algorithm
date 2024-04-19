package programmercarl;

import java.util.ArrayList;
import java.util.List;

class No46 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        this.nums = nums;

        dfs(used);

        return res;
    }

    private void dfs(boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(used);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}

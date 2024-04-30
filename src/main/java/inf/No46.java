package inf;

import java.util.ArrayList;
import java.util.List;

class No46 {


    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.used = new boolean[nums.length];
        dfs();

        return res;
    }

    private void dfs() {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs();
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

}

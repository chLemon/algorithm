package _solution.programmercarl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class No47 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    public static void main(String[] args) {
        No47 no = new No47();
        no.permuteUnique(new int[]{1, 1, 2});
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        this.nums = nums;
//        dfs(used);
        Arrays.sort(nums);
        dfs2(used);
        return res;
    }

    private void dfs2(boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            // 必须与同层的（!used）相同才跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);

                dfs2(used);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    private void dfs(boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        boolean[] layerSame = new boolean[22];
        for (int i = 0; i < used.length; i++) {
            if (used[i] || layerSame[nums[i] + 10]) continue;
            used[i] = true;
            path.add(nums[i]);
            layerSame[nums[i] + 10] = true;

            dfs(used);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

}

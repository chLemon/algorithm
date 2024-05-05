package _solution.inf;

import java.util.ArrayList;
import java.util.List;

class No78 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        // 选和不选
        dfs(0);

        return res;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(i + 1);

        path.add(nums[i]);
        dfs(i + 1);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> subsets2(int[] nums) {
        this.nums = nums;
        // 选谁。第n个数选谁，从下标 >= i 的数字里构造子集
        dfs2(0);

        return res;
    }

    private void dfs2(int i) {
        res.add(new ArrayList<>(path));

        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            dfs2(j + 1);
            path.remove(path.size() - 1);
        }
    }
}

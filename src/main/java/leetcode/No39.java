package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No39 {

    /*
    给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
    
    candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
    
    对于给定的输入，保证和为 target 的不同组合数少于 150 个。
    
    1 <= candidates.length <= 30
    2 <= candidates[i] <= 40
    candidates 的所有元素 互不相同
    1 <= target <= 40
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);

        backTracing(candidates, 0, target, 0, res, path);

        return res;
    }

    private void backTracing(int[] candidates, int start, int target, int sum, List<List<Integer>> res, List<Integer> path) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backTracing(candidates, i, target, sum + candidates[i], res, path);
            path.remove(path.size() - 1);
        }
    }


}

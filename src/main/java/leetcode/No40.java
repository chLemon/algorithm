package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40 {
    public static void main(String[] args) {
        No40 no = new No40();
        no.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    /*
    给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

    candidates 中的每个数字在每个组合中只能使用 一次 。
    
    注意：解集不能包含重复的组合。 
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);

        backTracing(candidates, 0, 0, target, res, path);
        return res;
    }

    private void backTracing(int[] candidates, int start, int sum, int target, List<List<Integer>> res, List<Integer> path) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backTracing(candidates, i + 1, sum + candidates[i], target, res, path);
            path.remove(path.size() - 1);
        }
    }

}

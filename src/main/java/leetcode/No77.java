package leetcode;

import java.util.ArrayList;
import java.util.List;

public class No77 {

    /*
    给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
    你可以按 任何顺序 返回答案。
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        combine(1, n, k, res, set);
        return res;
    }

    private void combine(int start, int n, int k, List<List<Integer>> res, List<Integer> set) {
        if (set.size() >= k) {
            res.add(new ArrayList<>(set));
            return;
        }

        for (int i = start; i <= n - k + set.size() + 1; i++) {
            set.add(i);
            combine(i + 1, n, k, res, set);
            set.remove(set.size() - 1);
        }
    }

}

package leetcode;

import java.util.ArrayList;
import java.util.List;

class No216 {

    public static void main(String[] args) {
        No216 no = new No216();
        System.out.println(no.combinationSum3(3, 7));
    }
    
    /*
    找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：

    只使用数字1到9
    每个数字 最多使用一次 
    返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
     */

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        combinationSum3(1, k, n, 0, res, path);
        return res;
    }

    private void combinationSum3(int start, int k, int n, int sum, List<List<Integer>> res, List<Integer> path) {
        if (sum > n) {
            return;
        }

        if (path.size() == k) {
            // 已达到k个
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            combinationSum3(i + 1, k, n, sum += i, res, path);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }

}

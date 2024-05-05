package _solution.inf;

import java.util.ArrayList;
import java.util.List;

class No216 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    int k;
    int n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;

        dfs2(1, n);

        return res;
    }

    private void dfs2(int i, int t) {
        if (t < 0) return;
        // 还可以选 9 - i + 1个数
        // 还需要选 k - path.size() 个数
        int d = k - path.size();
        if (9 - i + 1 < d) {    // 这个条件在这种写法下，好像不能合并
            return;
        }
        // 还要选 d 个
        // 最大的几个和应该是:
        // n ~ n - ( k - path.size) + 1
        // 这几个数的和应该是，(n - d + 1 + n)  * 项数/2
//        if (t > (n - d + 1 + n) * d / 2) {
//            // 假设 i 已经足够大了，为什么这里没有i相关的信息？？？
//            return;
//        }
        // 这里应该是 
        // 这里还是不对，剩下值里的最大值，要根据 i现在有多大分类讨论，不能简单 * d/ 2
        // 倒着来还是更方便一些啊
        if (t > (Math.max(i, n - d + 1) + n) * d / 2) {
            return;
        }

        // 选和不选的思路
        if (path.size() == k) {
            if (t == 0) {  // 这个条件可以和上面合并在一起
                res.add(new ArrayList<>(path));
            }
            return;
        }

        // 不选
        dfs2(i + 1, t);

        // 选
        path.add(i);
        dfs2(i + 1, t - i);
        path.remove(path.size() - 1);
    }

    private void dfs(int i, int t) {
        // 剩下的数，要凑成t
        // 如果 t < 0 说明前面选的和太大了
        // 如果 t > x 说明前面选的数太小了
        // x = 剩下数里，最大的几个和
        if (t < 0) {
            return;
        }
        // 还要选 k - path.size() 个
        // 最大的几个和应该是:
        // n ~ n - ( k - path.size) + 1
        // 这几个数的和应该是，(n - d + 1 + n)  * 项数/2
        int d = k - path.size();
        if (t > (n - d + 1 + n) * d / 2) {
            return;
        }

        if (path.size() == k) {
            if (t == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int j = i; j <= 9; j++) {
            path.add(j);
            dfs(j + 1, t - j);
            path.remove(path.size() - 1);
        }
    }

}

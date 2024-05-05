package _solution.programmercarl;

import java.util.ArrayList;
import java.util.List;

class No216 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;

    public static void main(String[] args) {
        No216 no = new No216();
        System.out.println(no.combinationSum3(3, 7));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.n = n;
        dfs(1, k, 0);
        return res;
    }

    private void dfs(int i, int k, int sum) {
        if (k == 0 && sum == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j <= 9 && sum + j <= n && 9 - j + 1 >= k; j++) {
            path.add(j);
            dfs(j + 1, k - 1, sum + j);
            path.remove(path.size() - 1);
        }
    }

}

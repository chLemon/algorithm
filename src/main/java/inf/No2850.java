package inf;

import java.util.ArrayList;
import java.util.List;

public class No2850 {

    public int minimumMoves(int[][] grid) {
        List<int[]> froms = new ArrayList<>();
        List<int[]> tos = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int x = grid[i][j];
                if (x > 1) {
                    for (int k = 0; k < x - 1; k++) {
                        froms.add(new int[]{i, j});
                    }
                } else if (x < 1) {
                    tos.add(new int[]{i, j});
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        // froms的全排列
        List<List<int[]>> pers = permutations(froms);
        for (List<int[]> per : pers) {
            // 每种排列
            int total = 0;
            for (int i = 0; i < per.size(); i++) {
                int[] f = per.get(i);
                int[] t = tos.get(i);
                total += Math.abs(f[0] - t[0]) + Math.abs(f[1] - t[1]);
            }
            ans = Math.min(ans, total);

        }
        return ans;
    }

    private List<List<int[]>> permutations(List<int[]> froms) {
        List<List<int[]>> res = new ArrayList<>();
        dfs(froms, 0, res);
        return res;
    }

    private void dfs(List<int[]> froms, int start, List<List<int[]>> res) {
        if (start == froms.size()) {
            res.add(new ArrayList<>(froms));
        }
        for (int i = start; i < froms.size(); i++) {
            swap(froms, start, i);
            dfs(froms, start + 1, res);
            swap(froms, start, i);
        }
    }

    private void swap(List<int[]> froms, int i, int j) {
        int[] tmp = froms.get(i);
        froms.set(i, froms.get(j));
        froms.set(j, tmp);
    }

}

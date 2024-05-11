package _solution.contest.biweekly.w130;

public class No1 {

    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 下面
                if (i + 1 < m) {
                    if (grid[i][j] != grid[i + 1][j]) {
                        return false;
                    }
                }
                // 右边
                if (j + 1 < n) {
                    if (grid[i][j] == grid[i][j + 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}

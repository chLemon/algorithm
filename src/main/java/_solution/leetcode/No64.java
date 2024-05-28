package _solution.leetcode;

public class No64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                    continue;
                }
                int left = i - 1 >= 0 ? f[i - 1][j] : 0x3f3f3f;
                int up = j - 1 >= 0 ? f[i][j - 1] : 0x3f3f3f;
                f[i][j] = Math.min(left, up) + grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }

}

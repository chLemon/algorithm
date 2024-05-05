package _solution.leetcode;

class No1020 {
    int m;
    int n;
    boolean[][] visited;
    int[] dir = new int[]{-1, 0, 1, 0, -1};

    public static void main(String[] args) {
        No1020 no = new No1020();
        no.numEnclaves(new int[][]{
                {0}, {1}, {1,}, {0}, {0}
        });
    }

    public int numEnclaves(int[][] grid) {
        // 周围寻找联通的地块，全部标记
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        // 两横
        for (int j = 0; j < n; j++) {
            if (!visited[0][j] && grid[0][j] == 1) {
                dfs(0, j, grid);
            }
            if (!visited[m - 1][j] && grid[m - 1][j] == 1) {
                dfs(m - 1, j, grid);
            }
        }

        // 两竖
        for (int i = 0; i < m; i++) {
            if (!visited[i][0] && grid[i][0] == 1) {
                dfs(i, 0, grid);
            }
            if (!visited[i][n - 1] && grid[i][n - 1] == 1) {
                dfs(i, n - 1, grid);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int[][] grid) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k];
            int nj = j + dir[k + 1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n
                    && !visited[ni][nj] && grid[ni][nj] == 1) {
                dfs(ni, nj, grid);
            }
        }
    }

}

package leetcode;

class No695 {

    int[] dir = new int[]{-1, 0, 1, 0, -1};

    public static void main(String[] args) {
        No695 no = new No695();
        no.maxAreaOfIsland(new int[][]{
                new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        });
    }

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, visited, grid));
                }
            }
        }
        return res;
    }

    // 遍历i j所在的大陆，返回面积
    private int dfs(int i, int j, boolean[][] visited, int[][] grid) {
        int sum = 1;
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k];
            int nj = j + dir[k + 1];
            if (ni >= 0 && ni < grid.length
                    && nj >= 0 && nj < grid[0].length
                    && !visited[ni][nj] && grid[ni][nj] == 1) {
                sum += dfs(ni, nj, visited, grid);
            }
        }
        return sum;
    }

}

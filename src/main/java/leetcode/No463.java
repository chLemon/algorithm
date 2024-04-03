package leetcode;

public class No463 {

    int[] dir = new int[]{-1, 0, 1, 0, -1};

    public static void main(String[] args) {
        No463 no = new No463();
        int i = no.islandPerimeter(new int[][]{
                {0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}
        });
        System.out.println(i);
    }

    /*
    这道题没有这么复杂。
    方法一：直接遍历每个块，根据周围有没有水，算其周长即可
    
    方法二：总周长=4*土地-2*接壤边数。遍历，土地land++，如果右/下边是土地，border++
     */
    public int islandPerimeter(int[][] grid) {
        // dfs遍历出岛屿，陆地周围的边界/海洋格子数就是周长
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 找到了岛屿，计算周长
                    return dfs(i, j, visited, grid);
                }
            }
        }

        return 0;
    }

    private int dfs(int i, int j, boolean[][] visited, int[][] grid) {
        int sum = 0;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k];
            int nj = j + dir[k + 1];
            if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || grid[ni][nj] == 0) {
                sum += 1;
            } else {
                if (!visited[ni][nj]) sum += dfs(ni, nj, visited, grid);
            }
        }
        return sum;
    }

}

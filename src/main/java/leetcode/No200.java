package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class No200 {

    public static void main(String[] args) {
        No200 no = new No200();
        no.numIslands22(new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        });
    }

    // 广度优先
    public int numIslands22(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int[] dir = new int[]{-1, 0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        // 广度优先
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res += 1;
                    // 当前节点直接访问，然后再加入queue
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int ni = poll[0] + dir[k];
                            int nj = poll[1] + dir[k + 1];
                            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj] && grid[ni][nj] != '0') {
                                // 节点先置为访问，这样在接下来就不会被重复加入
                                visited[ni][nj] = true;
                                queue.offer(new int[]{ni, nj});
                            }
                        }
                    }
                }
            }
        }

        return res;
    }


    // 广度优先1，超时，原因是有多个节点被重复加入
    public int numIslands21(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int[] dir = new int[]{-1, 0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        // 广度优先
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res += 1;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        visited[poll[0]][poll[1]] = true;
                        for (int k = 0; k < 4; k++) {
                            int ni = poll[0] + dir[k];
                            int nj = poll[1] + dir[k + 1];
                            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj] && grid[ni][nj] != '0') {
                                queue.offer(new int[]{ni, nj});
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    public int numIslands1(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                }
                res += 1;
                dfs(i, j, visited, grid);
            }
        }
        return res;
    }

    private void dfs(int i, int j, boolean[][] visited, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        // 访问当前节点
        visited[i][j] = true;
        // 访问其他节点
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            dfs(i + dir[k], j + dir[k + 1], visited, grid);
        }
    }

}

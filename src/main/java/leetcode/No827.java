package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class No827 {

    int[] dir = new int[]{-1, 0, 1, 0, -1};

    public static void main(String[] args) {
        No827 no = new No827();
        int i = no.largestIsland(new int[][]{{1, 1}, {0, 1}});
        System.out.println(i);
    }

    public int largestIsland(int[][] grid) {
        // 先处理岛屿
        Map<Integer, Integer> islandAreaMap = new HashMap<>();
        int islandNum = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    islandNum++;
                    int area = dfs(i, j, visited, grid, islandNum);
                    islandAreaMap.put(islandNum, area);
                }
            }
        }

        // 遍历每一处0，改为1寻找最大面积
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> nearby = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dir[k];
                        int nj = j + dir[k + 1];
                        if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && visited[ni][nj] != 0)
                            nearby.add(visited[ni][nj]);
                    }
                    maxArea = Math.max(maxArea, nearby.stream().mapToInt(islandAreaMap::get).sum() + 1);
                } else {
                    int area = islandAreaMap.get(visited[i][j]);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int i, int j, int[][] visited, int[][] grid, int islandNum) {
        int sum = 1;
        visited[i][j] = islandNum;
        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k];
            int nj = j + dir[k + 1];
            if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && visited[ni][nj] == 0 && grid[ni][nj] == 1) {
                sum += dfs(ni, nj, visited, grid, islandNum);
            }
        }
        return sum;
    }


}
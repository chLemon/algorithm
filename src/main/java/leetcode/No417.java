package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No417 {

    public static void main(String[] args) {
        No417 no = new No417();
        no.pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}
        });
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        // 第一行和第一列都可以
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i == 0 || j == 0) {
                    dfs(i, j, pacific, heights);
                }
                if (i == heights.length - 1 || j == heights[0].length - 1) {
                    dfs(i, j, atlantic, heights);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    private void dfs(int i, int j, boolean[][] ocean, int[][] heights) {
        // 当前点可以访问
        ocean[i][j] = true;

        int[] dir = new int[]{-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k];
            int nj = j + dir[k + 1];

            if (ni >= 0 && ni < heights.length && nj >= 0 && nj < heights[0].length
                    && !ocean[ni][nj] && heights[ni][nj] >= heights[i][j]) {
                dfs(ni, nj, ocean, heights);
            }
        }
    }

}

package contest.weekly.w394;

import java.util.Arrays;

public class No3 {

    public static void main(String[] args) {
        System.out.println(new No3().minimumOperations(new int[][]
                {{0, 2, 6, 0, 4, 8, 0, 5}, {3, 3, 9, 9, 3, 0, 3, 8}, {8, 3, 0, 5, 1, 6, 3, 6}, {0, 9, 2, 0, 6, 6, 9, 7}, {5, 8, 9, 3, 7, 1, 3, 4}, {0, 2, 0, 7, 9, 2, 6, 2}, {2, 4, 7, 1, 4, 7, 8, 2}, {3, 8, 0, 4, 0, 7, 6, 4}}
        ));
    }

    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[n][10];
        // 每一列，转变为某个数的成本
        int[][] costs = new int[n][10];
        for (int column = 0; column < n; column++) {
            // 每一列，全部转变为某个数的成本
            Arrays.fill(costs[column], m);
            for (int i = 0; i < m; i++) {
                costs[column][grid[i][column]]--;
            }
        }

        // f[0]初始化
        for (int i = 0; i < 10; i++) {
            f[0][i] = costs[0][i];
        }
        for (int column = 1; column < n; column++) {
            for (int i = 0; i < 10; i++) {
                // 对于新的一列，必须保证和左侧列不同，然后取最小值
                int cost = costs[column][i];
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < 10; j++) {
                    if (j != i) {
                        min = Math.min(min, f[column - 1][j]);
                    }
                }
                f[column][i] = cost + min;
            }
        }

        // 最后一列最小值
        int min = f[n - 1][0];
        for (int i = 1; i < 10; i++) {
            min = Math.min(f[n - 1][i], min);
        }
        return min;
    }

}

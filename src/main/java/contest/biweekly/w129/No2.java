package contest.biweekly.w129;

import java.util.Arrays;

class No2 {

    public static void main(String[] args) {
//        new No2().numberOfRightTriangles(new int[][]{{1, 0, 1}, {1, 0, 0}, {1, 0, 0}});
        System.out.println(new No2().numberOfRightTriangles(new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 1, 0}}));
    }

    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 提前处理，每个点，上下左右，有多少个1
        int[][] rightCount = new int[m][n];
        int[][] leftCount = new int[m][n];
        int[][] upCount = new int[m][n];
        int[][] downCount = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (j + 1 < n) {
                        leftCount[i][j + 1] = leftCount[i][j];
                    }
                    if (i + 1 < m) {
                        upCount[i + 1][j] = upCount[i][j];
                    }
                } else {
                    if (j + 1 < n) {
                        leftCount[i][j + 1] = leftCount[i][j] + 1;
                    }
                    if (i + 1 < m) {
                        upCount[i + 1][j] = upCount[i][j] + 1;
                    }
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    if (j - 1 >= 0) {
                        rightCount[i][j - 1] = rightCount[i][j];
                    }
                    if (i - 1 >= 0) {
                        downCount[i - 1][j] = downCount[i][j];
                    }
                } else {
                    if (j - 1 >= 0) {
                        rightCount[i][j - 1] = rightCount[i][j] + 1;
                    }
                    if (i - 1 >= 0) {
                        downCount[i - 1][j] = downCount[i][j] + 1;
                    }
                }
            }
        }
        System.out.println("**** rightCount");
        for (int[] ints : rightCount) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("****leftCount");
        for (int[] ints : leftCount) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("****upCount");
        for (int[] ints : upCount) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("****downCount");
        for (int[] ints : downCount) {
            System.out.println(Arrays.toString(ints));
        }

        long count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 每个点，看是否有4种三角形
                count += t1(grid, i, j, rightCount, downCount);
                count += t2(grid, i, j, leftCount, downCount);
                count += t3(grid, i, j, upCount, rightCount);
                count += t4(grid, i, j, leftCount, upCount);
            }
        }
        return count;
    }

    private long t4(int[][] grid, int i, int j, int[][] leftCount, int[][] upCount) {
        if (grid[i][j] == 0) {
            return 0;
        }
        // 当前点是1，
        int left = leftCount[i][j];
        int up = upCount[i][j];
        return left * up;
    }

    private long t3(int[][] grid, int i, int j, int[][] upCount, int[][] rightCount) {
        if (grid[i][j] == 0) {
            return 0;
        }
        // 当前点是1，
        int right = rightCount[i][j];
        int up = upCount[i][j];
        return right * up;
    }

    private long t2(int[][] grid, int i, int j, int[][] leftCount, int[][] downCount) {
        if (grid[i][j] == 0) {
            return 0;
        }
        // 当前点是1，
        int left = leftCount[i][j];
        int down = downCount[i][j];
        return left * down;
    }

    private long t1(int[][] grid, int i, int j, int[][] rightCount, int[][] downCount) {
        if (grid[i][j] == 0) {
            return 0;
        }
        // 当前点是1，
        int right = rightCount[i][j];
        int down = downCount[i][j];
        return right * down;
    }

}

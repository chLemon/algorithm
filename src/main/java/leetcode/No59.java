package leetcode;

import java.util.Arrays;

public class No59 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowIndex = 0;
        int colIndex = 0;
        int dir = 0;    // 0 向右 1 向下 2 向左 3 向上

        for (int i = 1; i <= n * n; i++) {
            res[rowIndex][colIndex] = i;

            int nextColIndex;
            int nextRowIndex;
            switch (dir) {
                case 0:
                    nextColIndex = colIndex + 1;
                    if (nextColIndex > n - 1
                            || res[rowIndex][nextColIndex] != 0) {
                        // 越界，或者右方有值，转向下
                        dir = 1;
                        rowIndex += 1;
                    } else {
                        colIndex = nextColIndex;
                    }
                    break;
                case 1:
                    // 向下过程中
                    nextRowIndex = rowIndex + 1;
                    if (nextRowIndex > n - 1
                            || res[nextRowIndex][colIndex] != 0) {
                        // 转向左
                        dir = 2;
                        colIndex -= 1;
                    } else {
                        rowIndex = nextRowIndex;
                    }
                    break;
                case 2:
                    // 向左过程中
                    nextColIndex = colIndex - 1;
                    if (nextColIndex < 0
                            || res[rowIndex][nextColIndex] != 0) {
                        // 转向上
                        dir = 3;
                        rowIndex -= 1;
                    } else {
                        colIndex = nextColIndex;
                    }
                    break;
                case 3:
                    // 向上过程中
                    nextRowIndex = rowIndex - 1;
                    if (nextRowIndex < 0
                            || res[nextRowIndex][colIndex] != 0) {
                        // 转向右
                        dir = 0;
                        colIndex += 1;
                    } else {
                        rowIndex = nextRowIndex;
                    }
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No59 no = new No59();
        int[][] res1 = no.generateMatrix(3);
        System.out.println(Arrays.deepToString(res1));

        int[][] res2 = no.generateMatrix(1);
        System.out.println(Arrays.deepToString(res2));
    }

}

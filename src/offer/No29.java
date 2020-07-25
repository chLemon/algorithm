package offer;

import org.junit.Test;

import java.util.Arrays;

public class No29 {
    /*
    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        if (matrix.length==0){
            return new int[0];
        }
        if (matrix.length == 1 && matrix[0].length == 1) {
            return new int[]{matrix[0][0]};
        }
        int rowStart = 0;
        int rowEnd = matrix[0].length - 1;
        int columnStart = 0;
        int columnEnd = matrix.length - 1;
        boolean row = true;
        boolean plus = true;
        int i = 0;
        int j = -1;
        int sum = (rowEnd + 1) * (columnEnd + 1);
        int[] result = new int[sum];
        int n = 0;
        while (n < sum) {

            if (j == rowEnd && row && plus) {
                row = false;
            } else if (i == columnEnd && !row && plus) {
                row = true;
                plus = false;
            } else if (row && j == rowStart && !plus) {
                row = false;

            } else if (!row && !plus && i == columnStart + 1) {
                row = true;
                plus = true;
                rowStart++;
                columnStart++;
                rowEnd--;
                columnEnd--;
            }

            if (row && plus) {
                j++;
            } else if (row && !plus) {
                j--;
            } else if (!row && plus) {
                i++;
            } else if (!row && !plus) {
                i--;
            }

            result[n] = matrix[i][j];
            n++;
        }
        return result;

        /*
        大神的代码
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;

         */
    }

    @Test
    public void test() {
        /*
        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        输出：[1,2,3,6,9,8,7,4,5]
         */
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
        System.out.println(Arrays.toString(spiralOrder(matrix=null)));
    }
}

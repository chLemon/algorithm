package solutions.codinginterviews;

public class No04 {

    /*
    在一个 n * m 的二维数组中，
    每一行都按照从左到右递增的顺序排序，
    每一列都按照从上到下递增的顺序排序。
    请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

    示例:
    现有矩阵 matrix 如下：
    [
      [1,   4,  7, 11, 15],
      [2,   5,  8, 12, 19],
      [3,   6,  9, 16, 22],
      [10, 13, 14, 17, 24],
      [18, 21, 23, 26, 30]
    ]
    给定 target = 5，返回 true。
    给定 target = 20，返回 false。
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        /*
        自己没想出来，看的解答：
        站在右上角的点上看，就是一个二叉搜索树
         */
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
            return false;
        }

        int r = 0;
        int c = matrix[0].length - 1;
        while (r < matrix.length && c > -1) {
            if (matrix[r][c] < target) {
                r++;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        /*现有矩阵 matrix 如下：
        [
          [1,   4,  7, 11, 15],
          [2,   5,  8, 12, 19],
          [3,   6,  9, 16, 22],
          [10, 13, 14, 17, 24],
          [18, 21, 23, 26, 30]
        ]
        给定 target = 5，返回 true。
        给定 target = 20，返回 false。
         */
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean numberIn2DArray = findNumberIn2DArray(matrix, 5);
        boolean numberIn2DArray1 = findNumberIn2DArray(matrix, 20);
        System.out.println(numberIn2DArray + "" + numberIn2DArray1);
        int[][] matrix2 = new int[][]{{-1, 3}};
        boolean numberIn2DArray2 = findNumberIn2DArray(matrix2, 3);
        System.out.println(numberIn2DArray2);
    }
}

package _solution.leetcode;

public class No240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i >= 0 && i < m && j >= 0 && j < n) {
            int x = matrix[i][j];
            if (x == target) return true;
            if (x < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}

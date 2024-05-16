package _solution.leetcode;

class No74 {

    // 2次二分
    public boolean searchMatrix1(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int x = matrix[mid][0];
            if (x == target) {
                return true;
            } else if (x < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 在left - 1所在的行内
        int i = left - 1;
        if (i < 0) return false;
        left = 0;
        right = matrix[0].length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int x = matrix[i][mid];
            if (x == target) {
                return true;
            } else if (x < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }

    // 从右上角看，抽像成一个BST
    public boolean searchMatrix2(int[][] matrix, int target) {
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

package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

class No54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int leftBound = 0;
        int rightBound = n - 1;
        int upBound = 0;
        int downBound = m - 1;
        while (leftBound <= rightBound && upBound <= downBound) {
            for (int j = leftBound; j <= rightBound; j++) {
                res.add(matrix[upBound][j]);
            }
            upBound++;
            if (leftBound > rightBound || upBound > downBound) break;

            for (int i = upBound; i <= downBound; i++) {
                res.add(matrix[i][rightBound]);
            }
            rightBound--;
            if (leftBound > rightBound || upBound > downBound) break;

            for (int j = rightBound; j >= leftBound; j--) {
                res.add(matrix[downBound][j]);
            }
            downBound--;
            if (leftBound > rightBound || upBound > downBound) break;

            for (int i = downBound; i >= upBound; i--) {
                res.add(matrix[i][leftBound]);
            }
            leftBound++;
        }
        return res;
    }
}

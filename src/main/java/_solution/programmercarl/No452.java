package _solution.programmercarl;

import java.util.Arrays;
import java.util.Comparator;

class No452 {

    public int findMinArrowShots(int[][] points) {
        // 根据左端点排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int right = Integer.MIN_VALUE;
        int count = 0;
        for (int[] point : points) {
            if (right == Integer.MIN_VALUE) {
                right = point[1];
                count++;
            } else {
                if (right < point[0]) {
                    right = point[1];
                    count++;
                } else {
                    right = Math.min(right, point[1]);
                }
            }
        }
        return count;
    }

}

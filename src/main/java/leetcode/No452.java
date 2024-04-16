package leetcode;

import java.util.Arrays;
import java.util.Comparator;

class No452 {

    public static void main(String[] args) {
        No452 no = new No452();
        no.findMinArrowShots(new int[][]{new int[]{-2147483648, 2147483647}});
    }

    public int findMinArrowShots(int[][] points) {
        // 用左端点排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int arrowCount = 0;
        long right = Long.MIN_VALUE;
        for (int[] point : points) {
            if (right < point[0]) {
                // 如果[left, right] 和point没有交集，箭+1，集合更新
                arrowCount++;
                right = point[1];
            } else {
                // 否则更新为交集 
                right = Math.min(right, point[1]);
            }
        }
        return arrowCount;
    }

    public int findMinArrowShots2(int[][] points) {
        // 用右端点升序
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int arrow = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (arrow < points[i][0]) {
                count++;
                arrow = points[i][1];
            }
        }
        return count;
    }


}

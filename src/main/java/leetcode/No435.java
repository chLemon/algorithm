package leetcode;

import java.util.Arrays;
import java.util.Comparator;

class No435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        // 左端点排序，遇到重叠的时候，去掉尾部更大的那个
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 0;
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] < right) {
                // 重叠，去掉尾部更大的那个
                count++;
                if (interval[1] < right) {
                    right = interval[1];
                }
            } else {
                // 不重叠，考察下一个
                right = interval[1];
            }
        }
        return count;
    }

}

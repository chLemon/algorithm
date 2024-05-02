package programmercarl;

import java.util.Arrays;
import java.util.Comparator;

class No435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 0;
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < right) {
                count++;
            } else {
                right = intervals[i][1];
            }
        }
        return count;
    }

}

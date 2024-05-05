package _solution.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class No56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> res = new ArrayList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= right) {
                // 如果重叠，合并
                right = Math.max(right, interval[1]);
            } else {
                // 如果不重叠，加入，并替换
                res.add(new int[]{left, right});
                left = interval[0];
                right = interval[1];
            }
        }
        // 加入最后一个
        res.add(new int[]{left, right});

        return res.toArray(new int[0][]);
    }

}

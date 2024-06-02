package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No57 {
    public static void main(String[] args) {
        new No57().insert(new int[][]{
                {1, 5}
        }, new int[]{2, 3});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int i = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            res.add(intervals[i++]);
        }

        // 可能的合并
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);

        // i处于最后一个合并的位置
        while (i < intervals.length) {
            res.add(intervals[i++]);
        }

        int[][] ans = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            ans[j] = res.get(j);
        }
        return ans;
    }

}

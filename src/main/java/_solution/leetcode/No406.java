package _solution.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class No406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> b[0] - a[0] != 0
                ? b[0] - a[0]
                : a[1] - b[1]);

        List<int[]> que = new LinkedList<>();
        for (int[] each : people) {
            que.add(each[1], each);
        }
        return que.toArray(new int[0][]);
    }

}

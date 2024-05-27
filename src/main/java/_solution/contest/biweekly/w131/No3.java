package _solution.contest.biweekly.w131;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class No3 {

    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> color2Count = new HashMap<>();
        Map<Integer, Integer> ball2Color = new HashMap<>();
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] op = queries[i];
            int ball = op[0];
            int color = op[1];

            // 之前ball有没有染色
            if (ball2Color.containsKey(ball)) {
                // ball有颜色了
                Integer oldColor = ball2Color.get(ball);
                // 去掉之前的染色统计
                if (color2Count.get(oldColor) == 1) {
                    color2Count.remove(oldColor);
                } else {
                    color2Count.merge(oldColor, -1, Integer::sum);
                }
            }
            // ball 染新色
            ball2Color.put(ball, color);
            color2Count.merge(color, 1, Integer::sum);

            // 这个操作后，被染色的个数是
            res[i] = color2Count.keySet().size();
        }
        return res;
    }

}

package programmercarl;

import java.util.Arrays;

public class No455 {

    public int findContentChildren(int[] g, int[] s) {
        // 小饼干应该优先分配出去；小胃口的人应该优先被满足
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;

        int gi = 0;
        for (int cookie : s) {
            if (gi < g.length && g[gi] <= cookie) {
                count++;
                gi++;
            }
        }
        return count;
    }

}

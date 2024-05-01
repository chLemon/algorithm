package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

class No2462 {

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        // 2 * candidates + k > n 时，刚好是前k个最小值
        if (2 * candidates + k > n) {
            Arrays.sort(costs);
            long res = 0;
            for (int i = 0; i < k; i++) {
                res += costs[i];
            }
            return res;
        }

        // 模拟
        PriorityQueue<Integer> pre = new PriorityQueue<>();
        PriorityQueue<Integer> suf = new PriorityQueue<>();
        int i = 0, j = n - 1;
        for (int l = 0; l < candidates; l++) {
            pre.offer(costs[i++]);
            suf.offer(costs[j--]);
        }
        // i, j 指向下一个待选
        long res = 0;
        for (int l = 0; l < k; l++) {
            if (pre.peek() <= suf.peek()) {
                res += pre.poll();
                pre.offer(costs[i++]);
            } else {
                res += suf.poll();
                suf.offer(costs[j--]);
            }
        }
        return res;
    }

}

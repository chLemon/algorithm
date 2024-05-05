package _solution.inf;

import java.util.Arrays;
import java.util.List;

class No2861 {

    public static void main(String[] args) {
        System.out.println(new No2861().maxNumberOfAlloys(1, 2, 24308609,
                Arrays.asList(Arrays.asList(88)),
                Arrays.asList(82685338),
                Arrays.asList(2)));
    }

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int max = 0;
        for (int i = 0; i < composition.size(); i++) {
            List<Integer> machine = composition.get(i);
            // 当前机器能做多少合金
            int capacity = alloy(budget, stock, machine, cost);
            max = Math.max(max, capacity);
        }
        return max;
    }

    private int alloy(int budget, List<Integer> stock, List<Integer> machine, List<Integer> cost) {
        // 最少是0
        int min = 0;
        // 最多能做 
        int max = 0;
        for (int i = 0; i < stock.size(); i++) {    // O(n)
            max = Math.max(max, stock.get(i) + budget / cost.get(i) / machine.get(i));
        }
        max = max + 1;

        // O(logMax)
        while (min < max) {
            int mid = min + (max - min) / 2;
            // 假设能做mid个，成本需要
            long total = 0;
            for (int i = 0; i < machine.size(); i++) {
                total += Math.max((long) mid * machine.get(i) - stock.get(i), 0) * cost.get(i);
            }
            if (total <= budget) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        // min - 1 还有富裕 或者刚好， max 则是 更多
        return min - 1;
    }

}

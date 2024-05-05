package _solution.programmercarl;

import java.util.Arrays;

class No134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        // 从耗油前缀和的第一个最小值出发，能到就能到，不能就不能
        int n = gas.length;

        int[] benefit = new int[n];
        for (int i = 0; i < n; i++) {
            benefit[i] = gas[i] - cost[i];
        }
        int[] benefitPrefixSum = new int[n];
        benefitPrefixSum[0] = benefit[0];
        for (int i = 1; i < n; i++) {
            benefitPrefixSum[i] = benefit[i] + benefitPrefixSum[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < benefitPrefixSum.length; i++) {
            // 这里要用等于，要取最后一个解，没汽油动不了
            if (min >= benefitPrefixSum[i]) {
                min = benefitPrefixSum[i];
                minIndex = i;
            }
        }
        minIndex = (minIndex + 1) % n;
        // 可以直接从这里根据 preSum 最后的值是否 > 0 判断是不是-1
        // 从minIndex出发试试
        return minIndex;
    }

}

package leetcode;

import java.util.Arrays;

class No1049 {

    public static void main(String[] args) {
        No1049 no = new No1049();
        no.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
    }

    public int lastStoneWeightII(int[] stones) {
        // 问题转换为，从stones里找到最近接stones.sum / 2的组合，另一组就是 sum - 此组合结果，res是组合一与组合二的差
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        // sum >> 1

        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }


}

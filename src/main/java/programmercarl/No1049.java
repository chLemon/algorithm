package programmercarl;

import java.util.Arrays;

public class No1049 {

    // 转换为在数字前加 + -，使得和>=且最小，再转换为 选一些数和接近总和的一半
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int n = stones.length;
        int[][] f = new int[n + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            int stone = stones[i - 1];
            for (int j = 1; j <= target; j++) {
                if (j < stone) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - stone] + stone);
                }
            }
        }
        int maxSum = f[n][target];
        return sum - maxSum - maxSum;
    }

}

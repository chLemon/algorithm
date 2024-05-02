package programmercarl;

import java.util.Arrays;

class No494 {

    public static void main(String[] args) {
        new No494().findTargetSumWays(new int[]{1, 0}, 1);
    }

    public int findTargetSumWays(int[] nums, int target) {
        /*
         sum+ - sum- = target
         sum+ + sum- = sum
         所以sum- = (sum - target) / 2
         
         在nums里选择下标不同的组合，使得和为sum-的方案有多少种
         f[i][j] 在考虑0~i个数的情况下，和为j的方案
         f[i][j] = f[i-1][j] + f[i-1][j-nums[i]]
         */

        int twice = Arrays.stream(nums).sum() - target;
        if ((twice & 1) == 1 || twice < 0) return 0;

        int sumMinus = twice / 2;

        int n = nums.length;
        int[][] f = new int[n + 1][sumMinus + 1];
        // 一个都不选的方案是0
        // 和为0的方案是1
        // 由于数里含有0，所以并不是1
        f[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = 0; j <= sumMinus; j++) {
                if (j < x) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j] + f[i - 1][j - x];
                }
            }
        }
        return f[n][sumMinus];
    }

}

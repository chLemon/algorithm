package _solution.inf;

import java.util.Arrays;

class No494 {

    public int findTargetSumWays(int[] nums, int target) {
        /*
         假设 plus sum = p, sum
         则 minus sum = s - p; target = p - m = p - (s - p) = 2 * p - s
         p = (target + s) / 2  
        即，选择若干数，使得和恰好为p的方案数
         */
        int s = Arrays.stream(nums).sum();
        int d = target + s;
        if ((d & 1) == 1) return -1;
        int p = d / 2;

        int n = nums.length;
        int[][] f = new int[n + 1][p + 1];
        // init
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = 0; j <= p; j++) {
                if (j < x) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j] + f[i - 1][j - x];
                }
            }
        }
        return f[n][p];
    }

}

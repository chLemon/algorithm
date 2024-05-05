package _solution.inf;

import java.util.Arrays;
import java.util.List;

class No2915 {

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        // 选择若干个数，使得和为target。求最大个数
        int INF = 0x3f3f3f;
        int n = nums.size();
        int[][] f = new int[n + 1][target + 1];
        // init
        Arrays.fill(f[0], -INF);
        f[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int x = nums.get(i - 1);
            for (int j = 0; j < target + 1; j++) {
                if (j < x) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - x] + 1);
                }
            }
        }
        return f[n][target] < 0 ? -1 : f[n][target];
    }

}

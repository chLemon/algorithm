package contest.weekly.w392;

import java.util.Arrays;

class No1 {

    public int longestMonotonicSubarray(int[] nums) {
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // 递增
                dp1[i] = dp1[i - 1] + 1;
            }
        }

        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                // 递减
                dp2[i] = dp2[i - 1] + 1;
            }
        }
        int max = 0;
        for (int i : dp1) {
            max = Math.max(max, i);
        }
        for (int i : dp2) {
            max = Math.max(max, i);
        }
        return max;

    }

}

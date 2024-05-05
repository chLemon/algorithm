package _solution.inf;

import java.util.Arrays;

class No2439 {

    public static void main(String[] args) {
        new No2439().minimizeArrayValue(new int[]{3, 7, 1, 6});
    }

    public int minimizeArrayValue(int[] nums) {
        // 二分答案
        int left = 0;
        int right = Arrays.stream(nums).max().orElse(0) + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums)) {
                // 如果满足，答案缩小
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 不变性：right是满足的，left -1 是不满足的
        return left;
    }

    private boolean check(int max, int[] nums) {
        long delta = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > max) {
                delta += nums[i] - max;
            } else {
                if (delta > 0) {
                    delta = Math.max(delta - (max - nums[i]), 0);
                }
            }
        }
        return nums[0] + delta <= max;
    }

}

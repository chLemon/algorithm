package contest.weekly.w392;

import java.util.Arrays;

class No3 {

    public static void main(String[] args) {
        No3 no = new No3();
        System.out.println(no.minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 4)); // 2
        System.out.println(no.minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 4)); // 3
        System.out.println(no.minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 4)); // 0
    }

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        // 2 5 [5] 6 8;
        // 1 2 5 [5] 5 6
        Arrays.sort(nums);
        int mid = nums.length / 2;
        // mid 要变为k，左侧大于k的也要变成k
        // mid 右侧小于k的也要变为k
        long targetSum = 0;
        long nowSum = 0;
        for (int i = mid - 1; i >= 0; i--) {
            if (nums[i] > k) {
                targetSum += k;
                nowSum += nums[i];
            }
        }
        long total = 0;
        // 先统计一下
        total = nowSum - targetSum;

        // mid右侧小于k的要增长为k
        targetSum = 0;
        nowSum = 0;

        for (int i = mid + 1; i < nums.length; i++) {
            if (nums[i] < k) {
                targetSum += k;
                nowSum += nums[i];
            }
        }
        total += targetSum - nowSum;

        // k的
        total += Math.abs(k - nums[mid]);
        return total;
    }

}

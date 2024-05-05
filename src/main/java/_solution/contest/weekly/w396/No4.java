package _solution.contest.weekly.w396;

import java.util.Arrays;

class No4 {

    public static void main(String[] args) {
        new No4().minCostToEqualizeArray(new int[]{4, 1}, 5, 2);
    }

    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        long sum = 0;
        int mod = (int) (1e9) + 7;
        Arrays.sort(nums);
        if (cost1 * 2 <= cost2) {
            // 全用c1
            for (int i = nums.length - 2; i >= 0; i--) {
                long tmp = ((long) nums[nums.length - 1] - nums[i]) * cost1;
                sum = (sum + tmp % mod) % mod;
            }
        } else {
            // 优先c2
            for (int i = nums.length - 2; i >= 0; i--) {
                if (i - 1 >= 0) {
                    // 有下一个
                    int diff = nums[nums.length - 1] - nums[i];

                    long cost = (long) diff * cost2;

                    sum = (sum + cost % mod) % mod;

                    nums[i - 1] += diff;
                } else {
                    // 没有下一个了
                    int diff = nums[nums.length - 1] - nums[i];
                    long cost = (long) diff * cost1;
                    sum = (sum + cost % mod) % mod;
                }
            }
        }

        return (int) (sum % mod);
    }

}

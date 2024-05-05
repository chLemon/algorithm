package _solution.inf;

import java.util.Arrays;

class No16 {

    public static void main(String[] args) {
        No16 no = new No16();
        int i = no.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(i);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = 0x3f3f3f;
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = x + nums[j] + nums[k];
                if (sum == target) return target;
                int diff = Math.abs(sum - target);
                if (minDiff > diff) {
                    minDiff = diff;
                    res = sum;
                }
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

}

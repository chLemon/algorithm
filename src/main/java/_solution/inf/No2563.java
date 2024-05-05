package _solution.inf;

import java.util.Arrays;

class No2563 {

    // 为了避免重复，并且 i != j，二分查找的时候，枚举一个找另一个。所以枚举右侧点
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        Arrays.sort(nums);
        for (int j = 0; j < nums.length; j++) {
            int x = nums[j];
            int upperIndex = binarySearch(nums, j, upper - x + 1);
            int lowerIndex = binarySearch(nums, j, lower - x);
            count += upperIndex - lowerIndex;
        }
        return count;
    }

    private int binarySearch(int[] nums, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}

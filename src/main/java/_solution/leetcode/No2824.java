package _solution.leetcode;

import java.util.Collections;
import java.util.List;

class No2824 {

    public int countPairs(List<Integer> nums, int target) {
        int count = 0;
        if (nums.size() <= 1) return count;
        Collections.sort(nums);
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum < target) {
                // left, left-right] 范围内都是答案
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

}

package endlesscheng;

import java.util.Arrays;

public class No1658 {

    // 正难则反
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        if (target < 0) return -1;

        // 求和恰为target的连续最长子数组的长度
        int maxLen = -1;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target) sum -= nums[left++];
            if (sum == target) maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen < 0 ? -1 : nums.length - maxLen;
    }

}

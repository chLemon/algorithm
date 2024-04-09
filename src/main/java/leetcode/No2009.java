package leetcode;

import java.util.Arrays;

class No2009 {

    public int minOperations(int[] nums) {
        // 滑动窗口，找到长为 nums.length 的窗口内最多的点的数量

        Arrays.sort(nums);
        int j = 1;  // 去重后的数组长度
        // 去重
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }

        // 滑动计数
        int res = 0;
        int left = 0;
        for (int i = 0; i < j; i++) {
            while (nums[left] < nums[i] - nums.length + 1) {
                // nums[left]不在窗口内
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return nums.length - res;
    }

}

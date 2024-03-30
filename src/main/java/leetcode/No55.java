package leetcode;

public class No55 {

    // 贪心1
    public boolean canJump(int[] nums) {
        int count0 = 0;
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        for (int i = nums.length - 2; i >= 0; i--) {
            int num = nums[i];
            if (num != 0 && num > count0) count0 = -1;
            count0++;
        }
        return count0 == 0;
    }

    // 贪心2
    public boolean canJump2(int[] nums) {
        // 维护可以到达的最远下标
        int maxReachableIndex = 0;
        int i = 0;
        for (; i < nums.length && i <= maxReachableIndex; i++) {
            maxReachableIndex = Math.max(maxReachableIndex, i + nums[i]);
        }
        return i == nums.length;
    }

}

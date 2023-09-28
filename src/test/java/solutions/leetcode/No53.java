package solutions.leetcode;

public class No53 {
    public int maxSubArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1] > 0 ? nums[i - 1] : 0;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = nums[i] > result ? nums[i] : result;
        }
        return result;
    }
}

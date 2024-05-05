package sword_to_offer;

class No42 {
    /*
    输入一个整型数组，
    数组里有正数也有负数。
    数组中的一个或连续多个整数组成一个子数组。
    求所有子数组的和的最大值。

    要求时间复杂度为O(n)。
     */
    public int maxSubArray(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i - 1] + nums[i];
            }
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

}

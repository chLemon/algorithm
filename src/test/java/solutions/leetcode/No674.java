package solutions.leetcode;

public class No674 {
    /*
    给定一个未经排序的整数数组，
    找到最长且连续的的递增序列，
    并返回该序列的长度。
     */
    public int findLengthOfLCIS(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        int temp = 1;
        result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                result = ++temp > result ? temp : result;
            } else {
                temp = 1;
            }
        }
        return result;
    }

}

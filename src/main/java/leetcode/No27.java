package leetcode;

import java.util.Arrays;

class No27 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int end = 0;
        for (int move = 0; move < nums.length; move++) {
            // 双指针
            if (nums[move] != val) {
                nums[end++] = nums[move];
            }
        }
        return end;
    }

    public static void main(String[] args) {
        No27 no = new No27();

        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        int res = no.removeElement(nums, val);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 示例 1：
     *
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     * 示例 2：
     *
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,3,0,4]
     * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
     */
}

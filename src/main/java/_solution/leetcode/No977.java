package _solution.leetcode;

import java.util.Arrays;

class No977 {

    /*
    示例 1：

    输入：nums = [-4,-1,0,3,10]
    输出：[0,1,9,16,100]
    解释：平方后，数组变为 [16,1,0,9,100]
    排序后，数组变为 [0,1,9,16,100]
    示例 2：

    输入：nums = [-7,-3,2,3,11]
    输出：[4,9,9,49,121]

     */
    public static void main(String[] args) {
        No977 n = new No977();
//        int[] t1 = new int[]{-4, 1, 0, 3, 10};
//        int[] r1 = n.sortedSquares(t1);
//        System.out.println(Arrays.toString(r1));

        int[] t2 = new int[]{-7, -3, 2, 3, 11};
        int[] r2 = n.sortedSquares(t2);
        System.out.println(Arrays.toString(r2));
    }

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        // 双指针，从后开始填充
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - 1;
        while (start <= end) {
            int pow;
            if (Math.abs(nums[start]) <= Math.abs(nums[end])) {
                pow = nums[end] * nums[end];
                end--;
            } else {
                pow = nums[start] * nums[start];
                start++;
            }

            res[index--] = pow;
        }
        return res;
    }

}

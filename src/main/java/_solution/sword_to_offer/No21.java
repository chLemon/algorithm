package _solution.sword_to_offer;

import java.util.Arrays;

class No21 {
    /*
    输入一个整数数组，
    实现一个函数来调整该数组中数字的顺序，
    使得所有奇数位于数组的前半部分，
    所有偶数位于数组的后半部分。
     */
    /*
    输入：nums = [1,2,3,4]
    输出：[1,3,2,4]
    注：[3,1,2,4] 也是正确的答案之一。
     */
    /*
    1 <= nums.length <= 50000
    1 <= nums[i] <= 10000
     */
    public int[] exchange(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            if (!isOdd(nums[head]) && isOdd(nums[tail])) {
                int tem = nums[head];
                nums[head] = nums[tail];
                nums[tail] = tem;
            }
            if (isOdd(nums[head])) {
                head++;
            }

            if (!isOdd(nums[tail])) {
                tail--;
            }
        }
        return nums;
    }

    public boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    public void test() {
        int[] ints = exchange(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }
}

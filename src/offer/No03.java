package offer;

import java.util.HashSet;
import java.util.Set;

public class No03 {
    /*
    找出数组中重复的数字。

    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    请找出数组中任意一个重复的数字。

    示例：
    输入：[2, 3, 1, 0, 2, 5, 3]
    输出：2 或 3
     */

    public int findRepeatNumber2(int[] nums) {

        /*
        最佳答案：原地哈希
        因为题目给了，所有数都在0-n-1范围内。
        使i处的值为i，一旦冲突即可返回。
        */

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    public int findRepeatNumber(int[] nums) {
        /*
        思路一：
        双重遍历
        O(n^2)

        思路二：
        拿一个值就放入一个有序列表中，然后二分法判断是否重复
        O(nlogn)
         */

        /*
        答案2
        利用HashSet去重，HashSet循key访问，就是O(1)
        总体复杂度就是O(n)
        空间O(n)
         */
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;

    }

    public void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    public static void main(String[] args) {
        int repeatNumber = new No03().findRepeatNumber(new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        System.out.println(repeatNumber);
    }
}

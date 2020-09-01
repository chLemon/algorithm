package zhousai89;

import org.junit.Test;

import java.lang.annotation.Target;

public class No3 {
    /*
    给你一个数组 nums 和一个整数 target 。

    请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
     */

    public int maxNonOverlapping(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int p = -1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (has(nums, p + 1, i, target)) {
                //如果从i倒着往前，到p，有等于target的，就把p移到i，并且result+1
                p = i;
                result++;
            }
        }
        return result;
    }

    public boolean has(int[] nums, int lo, int hi, int target) {
        int sum = 0;
        for (int i = hi; i >= lo; i--) {
            sum += nums[i];
            if (sum == target) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = new int[]{-2, 6, 6, 3, 5, 4, 1, 2, 8};
        maxNonOverlapping(nums, 10);
    }

}

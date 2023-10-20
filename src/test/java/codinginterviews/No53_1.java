package codinginterviews;

import org.junit.jupiter.api.Test;

public class No53_1 {
    /*
    统计一个数字在排序数组中出现的次数。
     */
    public int search(int[] nums, int target) {
//二分先找到一个，然后向前向后
        int lo = 0;
        int hi = nums.length;
        int mi = lo + (hi - lo) / 2;
        boolean has = false;
        int result = 0;
        while (lo < hi) {
            mi = lo + (hi - lo) / 2;
            if (nums[mi] == target) {
                has = true;
                break;
            } else if (nums[mi] < target) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        if (has) {
            result++;
            int i = mi - 1;
            int j = mi + 1;
            while (i >= 0 && i < nums.length && nums[i] == target) {
                result++;
                i--;
            }
            while (j >= 0 && j < nums.length && nums[j] == target) {
                result++;
                j++;
            }

            return result;
        } else {
            return 0;
        }

/*
邓公的版本C：
mi判断完，hi=mi，lo=mi+1，返回的是--lo

 */
//
//        public int search(int[] nums, int target) {
//            return helper(nums, target) - helper(nums, target - 1);
//        }
//        int helper(int[] nums, int tar) {
//            int i = 0, j = nums.length - 1;
//            while(i <= j) {
//                int m = (i + j) / 2;
//                if(nums[m] <= tar) i = m + 1;
//                else j = m - 1;
//            }
//            return i;
//        }


    }

    @Test
    public void test() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
        int i = search(nums, 6);
        System.out.println(i);
    }
}

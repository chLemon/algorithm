package leetCode;

import org.junit.Test;

public class No169 {
//    public int majorityElement(int[] nums) {
//        int lo = 0;
//        int hi = 1;
//        int count = 1;
//        while (hi < nums.length) {
//            if (nums[hi] == nums[lo]) {
//                count++;
//            }
//            if (hi - lo + 1 == 2 * count) {
//                lo = ++hi;
//                count = 1;
//            }
//            hi++;
//        }
//        return nums[lo];
//    }

    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    public int majorityElement(int[] nums, int lo, int hi) {
        if (hi == lo) {
            return nums[lo];
        }
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElement(nums, lo, mid);
        int right = majorityElement(nums, mid + 1, hi);

        if (left == right) {
            return left;
        } else {
            return count(nums, lo, mid, left) > count(nums, mid + 1, hi, right) ? left : right;
        }
    }

    public int count(int[] nums, int lo, int hi, int k) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == k) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int i = majorityElement(new int[]{
                2, 2, 1, 1, 1, 2, 2
        });
        System.out.println(i);
    }
}

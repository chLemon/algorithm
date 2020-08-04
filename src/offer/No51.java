package offer;

import org.junit.Test;

import java.util.Arrays;

public class No51 {
    /*
    在数组中的两个数字，
    如果前面一个数字大于后面的数字，
    则这两个数字组成一个逆序对。
    输入一个数组，求出这个数组中的逆序对的总数。
     */
    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int[] temp = new int[nums.length];

        return reversePairs(nums, 0, nums.length - 1, temp);
    }
    public int reversePairs(int[] nums, int lo, int hi, int[] temp) {
        if (lo == hi) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;

//        return reversePairs(nums, lo, mid, temp) + reversePairs(nums, mid + 1, hi, temp) + mergeCount(nums, lo, mid, hi, temp);
        int left = reversePairs(nums, lo, mid, temp);
        int right = reversePairs(nums, mid + 1, hi, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return left+right;
        }

        int merge = mergeCount(nums, lo, mid, hi, temp);


        return left+right+merge;
    }



    private int mergeCount(int[] nums, int lo, int mid, int hi, int[] temp) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        //排序且计算
        int count = 0;
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > hi) {
                nums[k] = temp[i];
                i++;
            } else {
                if (temp[i] <= temp[j]) {
                    nums[k] = temp[i];
                    i++;
                } else {
                    nums[k] = temp[j];
                    count += mid - i + 1;
                    j++;
                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        int[] nums = new int[]{7, 5, 6, 4};
        int i = reversePairs(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

}

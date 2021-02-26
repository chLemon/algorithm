package codinginterviews;

import org.junit.Test;

public class No57_1 {
    /*
    输入一个递增排序的数组和一个数字s，
    在数组中查找两个数，
    使得它们的和正好是s。
    如果有多对数字的和等于s，
    则输出任意一对即可。
     */
    public int[] twoSum(int[] nums, int target) {
        /*
        1 <= nums.length <= 10^5
        1 <= nums[i] <= 10^6
         */
        int[] result = new int[2];
        int j = binarySearch(nums, target) - 1;//如果匹配，就是i，如果不匹配，那么i左比它小，i右比它大
        int i = 0;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s == target) {
                result[0] = nums[i];
                result[1] = nums[j];
                break;
            } else if (s > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }


    public int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        int mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    //    public int[] twoSum(int[] nums, int target) {
//        int i = 0, j = nums.length - 1;
//        while(i < j) {
//            int s = nums[i] + nums[j];
//            if(s < target) i++;
//            else if(s > target) j--;
//            else return new int[] { nums[i], nums[j] };
//        }
//        return new int[0];
//    }
    @Test
    public void test() {
        twoSum(new int[]{2,7,11,15},9);
    }
}

package inf;

public class No34 {
    public static void main(String[] args) {
        new No34().searchRange(new int[]{}, 0);
    }

    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target);
        if (start >= nums.length || nums[start] != target) return new int[]{-1, -1};
        int end = binarySearch(nums, target + 1);
        return new int[]{start, end - 1};
    }

    // 返回该值第一个位置或者应该插入的位置
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}

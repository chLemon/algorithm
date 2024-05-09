package _solution.leetcode;

class No162 {

    public static void main(String[] args) {
        new No162().test(new int[]{1, 2, 3});
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 循环不变量：left - 1 < left     
        // right > right + 1
        return left;
    }

    public int test(int[] nums) {
        int left = -1, right = nums.length - 1; // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) right = mid; // 蓝色
            else left = mid; // 红色
        }
        return right;
    }
}

package leetcode;

class No34 {

    public int[] searchRange(int[] nums, int target) {
        int less = binarySearch(nums, target);
        int more = binarySearch(nums, target + 1);
        if (less < 0 || less >= nums.length || nums[less] != target) return new int[]{-1, -1,};
        return new int[]{less, more - 1};
    }

    // nums中寻找target出现的第一个下标，如果不存在，则为应该插入target处的下标
    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

}

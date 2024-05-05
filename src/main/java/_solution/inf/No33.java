package _solution.inf;

class No33 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int x = nums[nums.length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > x) {
                if (target <= x) {
                    left = mid + 1;
                } else {
                    if (target == nums[mid]) {
                        return mid;
                    } else if (target > nums[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            } else {
                if (target <= x) {
                    if (target == nums[mid]) {
                        return mid;
                    } else if (target > nums[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }

}

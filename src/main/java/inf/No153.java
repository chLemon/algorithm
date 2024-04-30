package inf;

class No153 {

    public static void main(String[] args) {
        System.out.println(new No153().findMin(new int[]{2, 1}));
    }

    public int findMin(int[] nums) {
        // 红蓝染色法，right已经是蓝色了
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {  // [)
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
                // left - 1 > right - 1
                // left - 1 < min
                // left <= min
            } else if (nums[mid] < nums[right]) {
                // right <<
                // right < min
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }


    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                // mid在target的左边
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // left - 1 > nums[-1], right <= nums[-1]
        return nums[left];
    }
}

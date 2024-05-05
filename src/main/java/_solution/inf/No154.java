package _solution.inf;

class No154 {

    public static void main(String[] args) {
        new No154().findMin(new int[]{3, 1, 3});
    }

    // 问题，有重复元素后，会出现 3 1 2 3 这样的情况，破坏了二段性
    // 可以考虑恢复，或者用区间右值判断
    public int findMin(int[] nums) {
        // 红蓝染色法：蓝色，min或在min右侧的值；红色min左侧的值
        // nums.length - 1 一定是蓝色
        int left = 0;
        int right = nums.length - 1;
        int x = nums[nums.length - 1];
        while (left < nums.length && nums[left] == x) {   // 跳过和x重复的left，从而恢复二段性
            left++;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > x) {
                // mid及mid左侧一定是红色
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 循环不变量： left = right, right一定是蓝色
        return nums[right];
    }

    // 区间右侧值写法
    public int findMin2(int[] nums) {
        // 红蓝染色
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {  // [)
            int mid = left + (right - left) / 2;
            int x = nums[right];
            if (nums[mid] > x) {
                left = mid + 1;
            } else if (nums[mid] < x) {
                right = mid;
            } else {
                // 相等的情况
                // 如果right-1是最小值，那么mid也是最小值，除非right-1=mid，否则最小值不会被去掉
                // >= right 的值是蓝色，所以无论如何都可以去掉 
                // 如果right-1不是最小值，那么去掉
                right--;
            }
        }
        return nums[right];
    }

}

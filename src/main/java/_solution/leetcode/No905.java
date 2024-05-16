package _solution.leetcode;

public class No905 {

    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int leftOdd = 0;
        int rightEven = n - 1;
        while (leftOdd < rightEven) {
            while (leftOdd < n && nums[leftOdd] % 2 == 0) {
                leftOdd++;
            }
            while (rightEven >= 0 && nums[rightEven] % 2 == 1) {
                rightEven--;
            }
            if (leftOdd < rightEven) {
                swap(nums, leftOdd, rightEven);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}

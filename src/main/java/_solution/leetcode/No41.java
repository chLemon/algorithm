package _solution.leetcode;

public class No41 {

    public static void main(String[] args) {
        System.out.println(new No41().firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        // 原地hash
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // nums[i] 已经在正确的位置上了，2种情况：
            // 1. i只有一个，现在就在正确的位置上。nums[i] == nums[i]
            // 2. 有重复的值，nums[i] = x = nums[x - 1]
            while (nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}

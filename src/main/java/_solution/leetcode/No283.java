package _solution.leetcode;

class No283 {

    /*
    summary:
    简单
    hot100

    思路：
    双指针，一个遍历，一个指向非0部分的末尾

    复杂度:
    时间 O(n)
    空间 O(1)
     */

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int noneZero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[noneZero++] = nums[i];
            }
        }
        for (; noneZero < n; noneZero++) {
            nums[noneZero] = 0;
        }
    }

}

package _solution.leetcode;

class No209 {

    /*
    给定一个含有 n 个正整数的数组和一个正整数 target 。

    找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组
    [numsl, numsl+1, ..., numsr-1, numsr] ，
    并返回其长度。如果不存在符合条件的子数组，返回 0 。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /*
   示例 1：

   输入：target = 7, nums = [2,3,1,2,4,3]
   输出：2
   解释：子数组 [4,3] 是该条件下的长度最小的子数组。
   示例 2：

   输入：target = 4, nums = [1,4,4]
   输出：1
   示例 3：

   输入：target = 11, nums = [1,1,1,1,1,1,1,1]
   输出：0
    */
    public static void main(String[] args) {
        No209 no = new No209();
        int[] nums1 = new int[]{2, 3, 1, 2, 4, 3};
        int target1 = 7;
        System.out.println(no.minSubArrayLen(target1, nums1));

        int[] nums2 = new int[]{1, 4, 4};
        int target2 = 4;
        System.out.println(no.minSubArrayLen(target2, nums2));

        int[] nums3 = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;
        System.out.println(no.minSubArrayLen(target3, nums3));
    }
}

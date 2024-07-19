package _solution.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class No15 {
    public static void main(String[] args) {
        No15 no = new No15();
        List<List<Integer>> lists = no.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    /*
    summary:
    中等
    hot100

    思路:
    下标不重复、且数值不重复
    排序后，用双指针做
    注意每一位数的去重
    注意第一个数遍历过程中可以进行剪枝优化

    复杂度:
    时间 O(n^2)
    空间 O(1)
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (nums == null || n < 3) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        // 三指针
        for (int i = 0; i < n - 2; i++) {
            // 第一个数去重
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            // 剪枝一
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            // 剪枝二
            if (nums[i] + nums[n - 2] + nums[n - 1] < 0) continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                // 第二个数去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    // 满足要求，加入res
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}

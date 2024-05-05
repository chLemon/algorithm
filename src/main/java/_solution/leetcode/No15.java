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

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        // 三指针
        for (int a = 0; a < nums.length; a++) {
            if (nums[a] > 0) {
                break;
            }
            int b = a + 1;
            int c = nums.length - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum == 0) {
                    // 满足要求，加入res
                    res.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    // 去重
                    while (b < c && nums[b] == nums[b + 1]) {
                        b++;
                    }
                    while (b < c && nums[c] == nums[c - 1]) {
                        c--;
                    }
                    b++;
                    c--;
                } else if (sum > 0) {
                    // 和过大，c左移
                    c--;
                } else {
                    // 和小，b右移
                    b++;
                }
            }
            // a去重
            while (a + 1 < nums.length - 1 && nums[a + 1] == nums[a]) {
                a++;
            }
        }
        return res;
    }
}

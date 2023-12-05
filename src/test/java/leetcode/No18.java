package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No18 {

    public static void main(String[] args) {
        No18 no = new No18();
        List<List<Integer>> lists = no.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        System.out.println(lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 四个指针 On^3试试行不行
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int a = 0; a < nums.length; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        while (c < d && nums[c + 1] == nums[c]) {
                            c++;
                        }
                        while (c < d && nums[d - 1] == nums[d]) {
                            d--;
                        }
                        c++;
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
                // b去重
                while (b + 1 < nums.length - 1 && nums[b + 1] == nums[b]) {
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

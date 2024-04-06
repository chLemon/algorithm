package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class No18 {

    public static void main(String[] args) {
        No18 no = new No18();
        List<List<Integer>> lists = no.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        System.out.println(lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int a = 0; a < nums.length; a++) {
            // 可以剪枝，但是要注意条件，得nums[a] > 0 如 -3 -2 -1 ... target = -4，-3>-4时还是可以继续加的
            if (nums[a] > 0 && nums[a] > target) {
                return res;
            }
            for (int b = a + 1; b < nums.length; b++) {
                // 二级剪枝，注意
                if (nums[a] + nums[b] > target && nums[a] + nums[b] > 0) {
                    // 如果不用return还得用label
                    return res;
                }
                // 还可以写成 nums[b] > 0 ，因为当 nums[a] + nums[b] > target时，需要后续2个数让这个和变小，但是如果nums[b]>0，后面都是正数，只能让这个和变大了
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

package _solution.programmercarl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class No18 {
    public static void main(String[] args) {
        No18 no = new No18();
        System.out.println(no.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            // 由于target有负数，不能乱剪枝

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int p = j + 1;
                int q = nums.length - 1;

                while (p < q) {
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        while (p < q && nums[p] == nums[p + 1]) {
                            p++;
                        }
                        while (p < q && nums[q] == nums[q - 1]) {
                            q--;
                        }
                        p++;
                        q--;
                    } else if (sum > target) {
                        q--;
                    } else {
                        p++;
                    }
                }

            }
        }

        return res;
    }

}

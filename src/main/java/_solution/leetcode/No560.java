package _solution.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No560 {

    public static void main(String[] args) {
        System.out.println(new No560().subarraySum(new int[]{1, 1, 1}, 2));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> presumCount = new HashMap<>();
        int presum = 0;
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            presum += nums[i];
            count += presumCount.getOrDefault(presum - k, 0);

            presumCount.merge(presum, 1, Integer::sum);
        }
        return count;
    }

}

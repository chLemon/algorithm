package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        Map<Integer, Integer> num2MinCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!num2MinCount.containsKey(num)) {
                num2MinCount.put(num, i);
            }
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = num2MinCount.get(res[i]);
        }
        return res;
    }

}

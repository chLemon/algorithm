package leetcode;

import java.util.HashMap;
import java.util.Map;

public class No1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            Map<Integer, Integer> number2Index = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (number2Index.containsKey(target - num)) {
                    res[0] = number2Index.get(target - num);
                    res[1] = i;
                    return res;
                }
                number2Index.put(num, i);
            }
            return res;
        }
    }

}

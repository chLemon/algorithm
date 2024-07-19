package _solution.leetcode;

import java.util.HashMap;
import java.util.Map;

class No1 {

/*
summary:
hot100
简单

思路:
HashMap 存 num -> index
从左到右遍历，查看是否有 target - nums[i] 的值，有返回，没有将当前值放入HashMap

复杂度:
时间 O(n)
空间 O(n)
 */

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

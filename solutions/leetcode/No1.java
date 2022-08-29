package leetcode;

import java.util.HashMap;
import java.util.Map;

public class No1 {

	class Solution {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int tar = target - nums[i];
				if (map.containsKey(tar)) {
					return new int[]{map.get(tar), i};
				}else {
					map.put(nums[i], i);
				}
			}
			return null;	
		}
	}
	
}

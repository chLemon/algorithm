package _solution.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class No599 {

	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map1 = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			map1.put(list1[i], i);
		}
		List<String> res = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list2.length; i++) {
			// 秒啊
			if (i > min) {
				break;
			}
			if (map1.containsKey(list2[i])) {
				int sum = map1.get(list2[i]) + i;
				if (sum < min) {
					min = sum;
					res.clear();
					res.add(list2[i]);
				} else if (sum == min) {
					res.add(list2[i]);
				}
			}
		}
		return res.toArray(new String[0]);
	}
}

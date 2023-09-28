package solutions.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class No3 {

	public int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, max = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (j < s.length()) {
			char c = s.charAt(j);
			if (map.containsKey(c) && map.get(c) >= i) {
				// 重复，计算之前的长度，i移动
				max = Math.max(max, j - i);
				i = map.get(c) + 1; // i移动到出现的那个字符的右边一个
			} 
			map.put(c, j);  // 更新字符的位置
			j++;    // 右指针右移
		}
		return Math.max(max, j - i);
	}

	@Test
	public void  test() {
		lengthOfLongestSubstring("abcabcbb");
	}
}

package codinginterviews;

import java.util.HashMap;
import java.util.Map;

public class No48 {
    /*
    请从字符串中找出一个最长的不包含重复字符的子字符串，
    计算该最长子字符串的长度。
     */

    public int lengthOfLongestSubstring(String s) {
        //遍历字符串，i为上一次s[j]出现的位置。若j-i<s[j-1]
        int result = 0;
        int cur = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j), j);
            cur = cur < j - i ? cur + 1 : j - i;
            result = Math.max(result, cur);
        }
        return result;
    }
}


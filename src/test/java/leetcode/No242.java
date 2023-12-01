package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No242 {


    public boolean isAnagram1(String s, String t) {
        // 字母异位词
        int[] nums = new int[26];
        for (char sChar : s.toCharArray()) {
            nums[sChar - 'a']++;
        }
        for (char tChar : t.toCharArray()) {
            nums[tChar - 'a']--;
        }
        return Arrays.stream(nums).allMatch(n -> n == 0);
    }

    public boolean isAnagram2(String s, String t) {
        Map<Character, Integer> letters = new HashMap<>();
        for (char sChar : s.toCharArray()) {
            letters.put(sChar, letters.getOrDefault(sChar, 0) + 1);
        }
        for (char tChar : t.toCharArray()) {
            letters.put(tChar, letters.getOrDefault(tChar, 0) - 1);
        }
        return letters.values().stream().allMatch(n -> n == 0);
    }
    
    /*
    示例 1:
    输入: s = "anagram", t = "nagaram"
    输出: true
    
    示例 2:
    输入: s = "rat", t = "car"
    输出: false
     */
}

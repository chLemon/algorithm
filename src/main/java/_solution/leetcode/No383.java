package _solution.leetcode;

import java.util.HashMap;
import java.util.Map;

class No383 {
    /*
    给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

    如果可以，返回 true ；否则返回 false 。

    magazine 中的每个字符只能在 ransomNote 中使用一次。

    示例 1：
    输入：ransomNote = "a", magazine = "b"
    输出：false

    示例 2：
    输入：ransomNote = "aa", magazine = "ab"
    输出：false

    示例 3：
    输入：ransomNote = "aa", magazine = "aab"
    输出：true
     */
    // 题目里其实还说了只有小写字母，用array就可以了
    // 可以最开始判断2个str的大小，shortcut
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> char2Count = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            char2Count.put(c, char2Count.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            char2Count.put(c, char2Count.getOrDefault(c, 0) - 1);
            if (char2Count.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

}

package _solution.leetcode;

import java.util.*;

class No49 {

    /*
    summary:
    中等
    hot100

    思路：
    用排序后的str作key，用 HashMap<String, List<String>> 分组

    复杂度:
    n = strs.length , m = strs[i].length
    时间 O(n*mlogm)
    空间 O(nm)
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sorted2Strs = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            sorted2Strs.computeIfAbsent(new String(chars), k -> new ArrayList<>())
                    .add(str);
        }
        return new ArrayList<>(sorted2Strs.values());
    }

}

package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

class No438 {

    /*
    summary:
    中等
    hot100

    思路:
    滑动窗口

    复杂度:
    时间 O(n)
    空间 O(26)
     */

    public static void main(String[] args) {
        List<Integer> anagrams = new No438().findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = p.length();
        int n = s.length();

        int[] pCount = new int[26];
        for (int i = 0; i < m; i++) {
            char c = p.charAt(i);
            pCount[c - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (pCount[i] > 0) diff++;
        }

        // []
        int left = 0;
        for (int i = 0; i < n; i++) {
            // in
            char c = s.charAt(i);
            int idx = c - 'a';
            if (pCount[idx] == 0) diff++;
            pCount[idx]--;
            if (pCount[idx] == 0) diff--;

            // out
            if (i - left + 1 > m) {
                int leftIdx = s.charAt(left++) - 'a';
                if (pCount[leftIdx] == 0) diff++;
                pCount[leftIdx]++;
                if (pCount[leftIdx++] == 0) diff--;
            }
            // cal
            if (diff == 0) {
                // 添加答案
                res.add(left);
            }
        }
        return res;
    }

}

package _solution.leetcode;

import java.util.HashSet;
import java.util.Set;

class No1044_ {

    long[] h;
    long[] base;
    int p = 13131;
    String s;
    int n;

    public static void main(String[] args) {
        String s1 = new No1044_().longestDupSubstring("abcd");
        System.out.println(s1);
    }

    public String longestDupSubstring(String s) {
        this.s = s;
        n = s.length();

        h = new long[n + 5];
        base = new long[n + 5];
        base[0] = 1;
        // 预处理
        for (int i = 0; i < n; i++) {
            base[i + 1] = base[i] * p;
            h[i + 1] = h[i] * p + s.charAt(i);
        }

        // 二分答案 [)
        int left = 0;
        int right = n;
        int[] res = new int[]{0, 0};
        while (left < right) {
            int len = left + (right - left) / 2;
            int[] checkRes = check(len);
            if (checkRes != null) {
                // len有答案，可以尝试继续扩大
                left = len + 1;
            } else {
                // len没有答案，太长了，缩小
                right = len;
            }
            if (checkRes != null) res = checkRes;
        }
        return s.substring(res[0], res[1]);
    }

    private int[] check(int len) {
        // 考察长为len的子串
        Set<Long> set = new HashSet<>();
        for (int i = 0, j = len - 1; j < n; i++, j++) {
            long curHash = h[j + 1] - h[i] * base[j - i + 1];
            if (set.contains(curHash)) return new int[]{i, j};
            set.add(curHash);
        }
        return null;
    }
}

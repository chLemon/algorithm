package _solution.contest.biweekly.w130;

import java.util.Arrays;

public class No3 {

    String s;
    int[] cache;

    public int minimumSubstringsInPartition(String s) {
        this.s = s;
        cache = new int[s.length() + 5];
        Arrays.fill(cache, -2);

        return dfs(0);
    }

    private int dfs(int start) {
        if (cache[start] != -2) {
            return cache[start];
        }
        if (start == s.length()) {
            cache[start] = 0;
            return 0;
        }

        // 从start开始，要求字母出现的次数一样。
        // 至少一个
        int min = Integer.MAX_VALUE;
        int[] wordCount = new int[26];
        for (int end = start + 1; end <= s.length(); end++) {
            char c = s.charAt(end - 1);
            wordCount[c - 'a']++;
            if (isValid(wordCount)) {
                // 新增一个分割
                int dfs = dfs(end) + 1;
                if (dfs != -1) {
                    min = Math.min(min, dfs);
                }
            }
        }
        int res = min == Integer.MAX_VALUE ? -1 : min;
        cache[start] = res;
        return res;
    }

    private boolean isValid(int[] wordCount) {
        // 要求非0值都一样
        int val = 0;
        for (int i : wordCount) {
            if (i == 0) {
                continue;
            }
            if (val == 0) {
                val = i;
            } else {
                if (val != i) return false;
            }
        }
        return true;
    }

}

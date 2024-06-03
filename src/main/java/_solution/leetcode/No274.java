package _solution.leetcode;

import java.util.Arrays;

class No274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            // 有 n - i 篇大于 x
            int x = citations[i];
            if (x >= n - i) {
                return n - i;
            }
        }
        return 0;
    }

    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int c : citations) {
            count[Math.min(c, n)]++;
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += count[i];    // 大于等于 i 的文章数量
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

}

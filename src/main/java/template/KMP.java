package template;

/**
 * LeetCode 28 (https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/)
 */
public class KMP {

    /**
     * 主算法思路：
     * <p>
     * s:   aaaaaaaaab
     * p:   aaab
     * 指针i, j 一起移动，匹配。
     * 当 s[i] 与 p[j] 失配时，j 移动到 next[j] 继续匹配
     */
    public int kmp(String s, String p) {
        if (s.length() < p.length()) return -1;

        int[] next = initNext(p);

        int i = 0;
        int j = 0;
        while (i < s.length() && j < p.length()) {
            // j < 0 表示没有匹配的，两个指针一起后移
            if (j < 0 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        // 如果是 j 遍历完了，说明p是s的子串。
        // 匹配的起始位置在 i - p.length
        return j == p.length() ? i - j : -1;
    }

    /**
     * next[j] 表示，j处失配后，应该去哪里继续匹配
     * abababab
     * ababc
     * 那应该是去，[0, j - 1] 中的 最长相同真前后缀 的下标处
     * 如上面的例子，就应该是 2
     * <p>
     * 特别的，j = 0 时， next[j] = -1
     */
    private int[] initNext(String p) {
        int[] next = new int[p.length()];
        next[0] = -1;
        int i = 1;  // 0 处理成 -1，从1开始

        int lastLS = next[i - 1];   // 上一次的最长子串
        while (i < p.length()) {
            // 求 next[i]
            // 求 [0, i - 1] 里的 LCPS
            if (lastLS < 0 || p.charAt(i - 1) == p.charAt(lastLS)) {
                next[i] = lastLS + 1;
                i++;
                lastLS++;
            } else {
                // 寻找下一个可能答案
                lastLS = next[lastLS];
            }
        }
        return next;
    }

}

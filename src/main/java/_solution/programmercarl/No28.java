package _solution.programmercarl;

class No28 {

    /*
    串匹配，KMP
     */
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int[] next = initNext(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j < 0 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        return j == needle.length() ? i - j : -1;
    }

    private int[] initNext(String pattern) {
        int[] next = new int[pattern.length()];
        int i = 1;
        int j = next[0] = -1;   // 循环考察的变量
        while (i < pattern.length()) {
            // j < 0 ? 表示 j=n[j] 的终止条件
            if (j < 0 || pattern.charAt(i - 1) == pattern.charAt(j)) {
                next[i++] = ++j;
            } else {
                // 不相等，循环考察下一个
                j = next[j];
            }
        }
        return next;
    }

}

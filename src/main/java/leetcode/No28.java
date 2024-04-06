package leetcode;

class No28 {

    public static void main(String[] args) {
        No28 no = new No28();
        int r1 = no.kmp("sadbutsad", "sad");
        System.out.println(r1); // 0
        int r2 = no.kmp("leetcode", "leeto");
        System.out.println(r2); // -1
        int r3 = no.kmp("a", "a");
        System.out.println(r3); // 0
        int r4 = no.kmp("mississippi", "issip");
        System.out.println(r4); // 0
    }

    // 不考虑KMP，记不住
    public int strStr(String haystack, String needle) {
        outer:
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 1; j < needle.length(); j++) {
                    if (i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
                        continue outer;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    /**
     * KMP
     */
    public int kmp(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int[] next = initNext3(needle);
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
        int j = next[0] = -1;
        int i = 1;
        while (i < pattern.length()) {
            if (j < 0 || pattern.charAt(i - 1) == pattern.charAt(j)) {
                next[i++] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * 优化后的版本，其实这边的i从0开始，会更简洁
     */
    private int[] initNext2(String pattern) {
        int[] next = new int[pattern.length()];
        int j = next[0] = -1;
        int i = 1;
        while (i < pattern.length()) {
            if (j < 0 || pattern.charAt(i - 1) == pattern.charAt(j)) {
                j++;
                next[i] = pattern.charAt(j) != pattern.charAt(i) ? j : next[j];
                i++;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    private int[] initNext3(String pattern) {
        int[] next = new int[pattern.length()];
        int j = next[0] = -1;
        int i = 0;
        while (i < pattern.length() - 1) {
            if (j < 0 || pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;
                next[i] = pattern.charAt(j) != pattern.charAt(i) ? j : next[j];
            } else {
                j = next[j];
            }
        }
        return next;
    }
}

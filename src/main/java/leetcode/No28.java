package leetcode;

public class No28 {

    public static void main(String[] args) {
        No28 no = new No28();
        assert no.strStr("sadbutsad", "sad") == 0;
        assert no.strStr("leetcode", "leeto") == -1;
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
        return i - j < 0 ? -1 : i - j;
    }

    private int[] initNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(next[i])) {
                next[i] = next[next[i + 1]] + 1;
            }
        }

        return next;
    }
}

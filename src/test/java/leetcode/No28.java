package leetcode;

public class No28 {

    public static void main(String[] args) {
        No28 no = new No28();
        int i = no.strStr("leetcode", "leeto");
        System.out.println(i);
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
}

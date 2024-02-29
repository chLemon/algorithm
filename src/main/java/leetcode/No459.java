package leetcode;

public class No459 {

    public static void main(String[] args) {
        No459 no = new No459();
//        System.out.println(no.repeatedSubstringPattern("abab"));    // t
//        System.out.println(no.repeatedSubstringPattern("aba"));     // f
//        System.out.println(no.repeatedSubstringPattern("abacababacab"));    // t
        System.out.println(no.repeatedSubstringPattern("abac"));    // f
    }

    public boolean repeatedSubstringPattern(String s) {
        // 尝试构建next表
        int[] next = new int[s.length() + 1];
        int i = 0;
        int t = next[0] = -1;
        while (i < s.length()) {
            if (t < 0 || s.charAt(i) == s.charAt(t)) {
                next[++i] = ++t;
            } else {
                t = next[t];
            }
        }
        // next表构建完成
        int subMax = next[s.length()];
        return subMax != 0 && subMax % (s.length() - subMax) == 0;
    }

}

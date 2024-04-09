package programmercarl;

public class No459 {

    public static void main(String[] args) {
        No459 no = new No459();
        boolean b = no.repeatedSubstringPattern("ababa");
        System.out.println(b);
    }

    public boolean repeatedSubstringPattern(String s) {
        // 构造next表，为了求 s 中的最大相等前后缀， + 1
        // 然后判断 next[len - 1] + 1是不是 len - n[len] + 1 的整数倍
        int[] next = new int[s.length() + 1];
        int j = next[0] = -1;
        int i = 1;
        while (i < s.length() + 1) {
            // j = next[i - 1]
            if (j < 0 || s.charAt(i - 1) == s.charAt(j)) {
                next[i++] = ++j;
            } else {
                j = next[j];
            }
        }
        int maxSub = next[s.length()];
        return maxSub > 0 && (maxSub % (s.length() - maxSub) == 0);
    }

}

package leetcode;

import java.util.stream.Stream;

public class No459 {

    public static void main(String[] args) {
        No459 no = new No459();
        System.out.println(no.repeatedSubstringPattern("abacababacab"));
        // abacab
        // abacab
    }

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) != s.charAt(0)) i++;
            // i和第一个字符一样
            int repeatStartIndex = i;
            int j = 0;
            while (i < s.length() && s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            }
            if (repeatStartIndex + j == s.length() && j >= repeatStartIndex && s.length() % repeatStartIndex == 0) {
                return true;
            }
        }
        return false;
    }
    

}

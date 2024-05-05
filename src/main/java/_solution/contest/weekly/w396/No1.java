package _solution.contest.weekly.w396;

import java.util.HashSet;
import java.util.Set;

class No1 {

    public static void main(String[] args) {
        new No1().isValid("xiUz");
    }

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean vowel = false;
        boolean conso = false;
        Set<Character> v = new HashSet<>();
        v.add('a');
        v.add('A');
        v.add('e');
        v.add('E');
        v.add('i');
        v.add('I');
        v.add('o');
        v.add('O');
        v.add('u');
        v.add('U');
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '@' || c == '#' || c == '$') {
                return false;
            }
            if (!('0' <= c && c <= '9')) {
                if (v.contains(c)) {
                    vowel = true;
                } else {
                    conso = true;
                }
            }
        }

        return vowel && conso;
    }

}

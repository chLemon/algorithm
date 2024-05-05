package contest.weekly.w396;

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
        Set<Character> legal = new HashSet<>();
        for (char i = '0'; i <= '9'; i++) {
            legal.add(i);
        }
        for (char i = 'a'; i <= 'z'; i++) {
            legal.add(i);
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            legal.add(i);
        }
        Set<Character> yuan = new HashSet<>();
        yuan.add('a');
        yuan.add('A');
        yuan.add('e');
        yuan.add('E');
        yuan.add('i');
        yuan.add('I');
        yuan.add('o');
        yuan.add('O');
        yuan.add('u');
        yuan.add('U');

        boolean hasYuan = false;
        boolean hasFu = false;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!legal.contains(c)) {
                return false;
            }
            if (yuan.contains(c)) {
                hasYuan = true;
                continue;
            }
            if ('a' <= c && c <= 'z') {
                hasFu = true;
            }
            if ('A' <= c && c <= 'Z') {
                hasFu = true;

            }
        }

        return hasYuan && hasFu;
    }

}

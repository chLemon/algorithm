package contest.weekly.w394;

public class No1 {

    public int numberOfSpecialChars(String word) {
        boolean[] little = new boolean[26];
        boolean[] big = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                little[c - 'a'] = true;
            } else {
                big[c - 'A'] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (little[i] && big[i]) {
                count++;
            }
        }
        return count;
    }
}

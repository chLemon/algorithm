package _solution.contest.weekly.w396;

import java.util.Arrays;

class No3 {

    public int minAnagramLength(String s) {
        int n = s.length();
        for (int k = 1; k < n / 2 + 1; k++) {
            if (n % k != 0) {
                continue;
            }
            if (can(s, k)) {
                return k;
            }
        }
        return n;
    }

    private boolean can(String s, int k) {
        int[] count = new int[26];
        for (int i = 0; i < k; i++) {
            count[s.charAt(i) - 'a']++;
        }
        int[] tmp = new int[26];
        for (int i = k; i < s.length(); ) {
            for (int j = 0; j < k; j++, i++) {
                tmp[s.charAt(i) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (count[j] != tmp[j]) {
                    return false;
                }
            }
            Arrays.fill(tmp, 0);
        }
        return true;
    }

}

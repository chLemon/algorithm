package _solution.contest.weekly.w397;

import java.util.Arrays;

public class No1 {
    public static void main(String[] args) {
        new No1().findPermutationDifference("rwohu",
                "rwuoh");
    }

    public int findPermutationDifference(String s, String t) {
        int n = s.length();
        int[] ss = new int[26];
        Arrays.fill(ss, -1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            ss[c - 'a'] = i;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            int lastIndex = ss[c - 'a'];
            res += Math.abs(i - lastIndex);
        }
        return res;
    }

}

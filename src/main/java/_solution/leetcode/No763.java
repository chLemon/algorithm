package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

class No763 {

    public static void main(String[] args) {
        No763 no = new No763();
        no.partitionLabels("ababcbacadefegdehijhklij");
    }

    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            lastIndex[index] = Math.max(lastIndex[index], i);
        }

        List<Integer> res = new ArrayList<>();
        int lastAddIndex = -1;
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            last = Math.max(lastIndex[index], last);
            if (i == last) {
                res.add(i - lastAddIndex);
                lastAddIndex = last;
            }
        }
        return res;
    }

}

package programmercarl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class No763 {

    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);
        for (int i = s.length() - 1; i >= 0; i--) {
            int index = s.charAt(i) - 'a';
            if (lastIndex[index] == -1) lastIndex[index] = i;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0;
        int moveTo = -1;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            moveTo = Math.max(moveTo, lastIndex[index]);
            if (i == moveTo) {
                res.add(moveTo - start + 1);
                start = moveTo + 1;
            }
        }
        return res;
    }

}

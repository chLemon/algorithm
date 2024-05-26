package _solution.contest.biweekly.w131;

import java.util.HashSet;
import java.util.Set;

public class No1 {

    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> once = new HashSet<>();
        Set<Integer> twice = new HashSet<>();
        for (int i : nums) {
            if (once.contains(i)) {
                twice.add(i);
            }
            once.add(i);
        }
        Integer res = null;
        for (Integer i : twice) {
            if (res == null) {
                res = i;
            } else {
                res = res ^ i;
            }
        }
        return res == null ? 0 : res;
    }
}

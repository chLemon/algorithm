package _solution.leetcode;

import java.util.HashSet;
import java.util.Set;

public class No128 {


    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int max = 0;
        for (int i : nums) {
            if (set.contains(i - 1)) continue;
            int j = 1;
            while (set.contains(i + j)) {
                j++;
            }
            max = Math.max(max, j);
        }
        return max;
    }

}

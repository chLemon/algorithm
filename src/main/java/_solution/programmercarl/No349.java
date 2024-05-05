package _solution.programmercarl;

import java.util.HashSet;
import java.util.Set;

class No349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        // nums1.stream.boxed.toSet
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(a -> a).toArray();
    }

}

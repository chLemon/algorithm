package _solution.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class No349 {

    /*
    示例 1：
    输入：nums1 = [1,2,2,1], nums2 = [2,2]
    输出：[2]
    
    示例 2：
    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出：[9,4]
    解释：[4,9] 也是可通过的
     */
    public int[] intersection(int[] nums1, int[] nums2) {
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
        return res.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {

        Set<Integer> set1 = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2)
                .boxed()
                .collect(Collectors.toSet());
        set1.retainAll(set2);
        return set1.stream().mapToInt(i -> i).toArray();
    }

}

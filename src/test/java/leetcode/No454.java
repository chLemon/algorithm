package leetcode;

import java.util.HashMap;
import java.util.Map;

public class No454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 暴力On^4，map可以降低一重，如果22分组，则On^2
        Map<Integer, Integer> sum12Count = new HashMap<>();
        for (int i1 : nums1) {
            for (int i2 : nums2) {
                int sum12 = i1 + i2;
                sum12Count.put(sum12, sum12Count.getOrDefault(sum12, 0) + 1);
            }
        }
        // 12的和已求完，接下来看34和里有没有匹配的
        int res = 0;
        for (int i3 : nums3) {
            for (int i4 : nums4) {
                int wanted = -i3 - i4;
                res += sum12Count.getOrDefault(wanted, 0);
            }
        }
        return res;
    }

}

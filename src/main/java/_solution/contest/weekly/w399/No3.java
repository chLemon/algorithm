package _solution.contest.weekly.w399;

import java.util.Arrays;

public class No3 {

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] *= k;
        }
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            if (x % k != 0) continue;
            for (int j = 0; j < nums2.length; j++) {
                int y = nums2[j];
                if (y > x) {
                    break;
                }
                if (x % y == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}

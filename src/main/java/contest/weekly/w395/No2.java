package contest.weekly.w395;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No2 {


    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n2 = nums2[0];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] -= n2;
        }

        int n11 = nums1[0];
        int n12 = nums1[1];
        int n13 = nums1[2];

        int min = Integer.MAX_VALUE;
        toZero(nums1, 0);

        System.out.println(Arrays.toString(nums1));
        System.out.println(n11 - n2);

        if (contains(nums1, nums2)) {
            min = Math.min(n2 - n11, min);
        }
        toZero(nums1, 1);

        System.out.println(Arrays.toString(nums1));
        System.out.println(n12 - n2);

        if (contains(nums1, nums2)) {
            min = Math.min(n2 - n12, min);
        }
        toZero(nums1, 2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(n13 - n2);

        if (contains(nums1, nums2)) {
            min = Math.min(n2 - n13, min);
        }
        return min;


    }

    private boolean contains(int[] nums1, int[] nums2) {
        // 如果nums1里包含nums2的所有元素
        Map<Integer, Integer> number2Count = new HashMap<>();
        for (int i : nums1) {
            number2Count.merge(i, 1, Integer::sum);
        }
        for (int x : nums2) {
            Integer c = number2Count.get(x);
            if (c == null || c <= 0) {
                return false;
            }
            number2Count.put(x, c - 1);
        }
        return true;
    }

    private void toZero(int[] nums1, int start) {
        int x = nums1[start];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] -= x;
        }
    }

}

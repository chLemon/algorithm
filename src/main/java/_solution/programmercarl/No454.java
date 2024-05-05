package _solution.programmercarl;

import java.util.HashMap;
import java.util.Map;

class No454 {

    public static void main(String[] args) {
        No454 no = new No454();
        no.fourSumCount(new int[]{0, 1, -1}, new int[]{-1, 1, 0}, new int[]{0, 0, 1}, new int[]{-1, 1, 1});
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 两两一组，很重要
        Map<Integer, Integer> sum12Count = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                sum12Count.put(n1 + n2, sum12Count.getOrDefault(n1 + n2, 0));
            }
        }

        int count = 0;

        for (int n3 : nums3) {
            for (int n4 : nums4) {
                count += sum12Count.getOrDefault(-n3 - n4, 0);
            }
        }
        return count;
    }

}

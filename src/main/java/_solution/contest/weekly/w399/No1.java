package _solution.contest.weekly.w399;

public class No1 {

    public static void main(String[] args) {
        System.out.println(new No1().numberOfPairs(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
    }

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] *= k;
        }
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                int y = nums2[j];
                if (x >= y && x % y == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

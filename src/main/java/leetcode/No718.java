package leetcode;

public class No718 {

    public static void main(String[] args) {
        No718 no = new No718();
        no.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
    }

    public int findLength(int[] nums1, int[] nums2) {
        int[][] f = new int[nums1.length + 1][nums2.length + 1];

        int max = -0x3f3f3f;
        for (int i = 1; i <= nums1.length; i++) {
            int n1 = nums1[i - 1];
            for (int j = 1; j <= nums2.length; j++) {
                int n2 = nums2[j - 1];
                f[i][j] = n1 == n2 ? f[i - 1][j - 1] + 1 : 0;
                max = Math.max(f[i][j], max);
            }
        }
        return max;
    }

    public int findLength2(int[] nums1, int[] nums2) {
        int max = -0x3f3f3f;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int p = i;
                    int q = j;
                    while (q < nums2.length && p < nums1.length && nums2[q] == nums1[p]) {
                        p++;
                        q++;
                    }
                    max = Math.max(q - j, max);
                }
            }
        }

        return Math.max(max, 0);
    }

}

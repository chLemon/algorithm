package _solution.leetcode;

class No1035 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] f = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            int n1 = nums1[i - 1];
            for (int j = 1; j <= nums2.length; j++) {
                int n2 = nums2[j - 1];
                if (n1 == n2) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[nums1.length][nums2.length];
    }

}

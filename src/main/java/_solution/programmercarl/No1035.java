package _solution.programmercarl;

class No1035 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] f = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    f[i][j] = 1 + f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
                max = Math.max(max, f[i][j]);
            }
        }
        return max;
    }

}

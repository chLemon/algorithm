package _solution.programmercarl;

import domain.TreeNode;
class No474 {

    public static void main(String[] args) {
        new No474().findMaxForm(new String[]{"10", "0", "1"}, 0, 1);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] f = new int[strs.length + 1][m + 1][n + 1];
        // f[i][j][k] 考虑0~i个字符串时，恰好有j个0和k个1的最大子集长度
        // 初始化问题：i = 0 || j = 0 时，为0，i为0时，也为0
        for (int i = 1; i <= strs.length; i++) {
            String str = strs[i - 1];
            int count0 = 0;
            int count1 = 0;
            for (int z = 0; z < str.length(); z++) {
                if (str.charAt(z) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j < count0 || k < count1) {
                        f[i][j][k] = f[i - 1][j][k];
                    } else {
                        f[i][j][k] = Math.max(f[i - 1][j][k], f[i - 1][j - count0][k - count1] + 1);
                    }
                }
            }
        }
        return f[strs.length][m][n];
    }

}

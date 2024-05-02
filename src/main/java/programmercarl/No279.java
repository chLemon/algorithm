package programmercarl;

import java.util.Arrays;

class No279 {

    public int numSquares(int n) {
        int INF = 0x3f3f3f;
        int[][] f = new int[101][n + 1];
        // 初始化比较特殊
        // 没有值时，不能凑成结果
        Arrays.fill(f[0], INF);
        f[0][0] = 0;
        // 初始化比较特殊，后确定
        int i;
        for (i = 1; i <= 100 && i * i <= n; i++) {
            int square = i * i;
            // 
            for (int j = 0; j <= n; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= square) {
                    f[i][j] = Math.min(f[i][j], f[i][j - square] + 1);
                }
            }
        }

        return f[i - 1][n];
    }

}

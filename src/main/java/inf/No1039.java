package inf;

public class No1039 {

    public int minScoreTriangulation(int[] values) {
        int n = values.length;

        /*
        f(i,j) i,j为边，i开始的多边形的minScore
        
        f(i,j) = min(  枚举i<k<j, f(i,k) + ikj + f(k,j)  )
        i是从更大的数转移而来
        j是从更小的数转移而来
         */
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                int min = 0x3f3f3f;
                for (int k = i + 1; k < j; k++) {
                    min = Math.min(min, f[i][k] + f[k][j] + values[i] * values[j] * values[k]);
                }
                f[i][j] = min;
            }
        }
        return f[0][n - 1];
    }

}

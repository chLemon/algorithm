package leetcode;

import java.util.Arrays;

public class No279 {

    public static void main(String[] args) {
        No279 no = new No279();
        no.numSquares(1);
    }

    public int numSquares(int n) {
        int INF = Integer.MAX_VALUE;
        int max = (int) Math.ceil(Math.sqrt(n));
        int[] f = new int[n + 1];
        Arrays.fill(f, INF);
        f[0] = 0;

        // 这里直接  i * i < n
        for (int i = 1; i <= max; i++) {
            int cost = i * i;
            for (int j = cost; j <= n; j++) {
                if (f[j - cost] != INF) f[j] = Math.min(f[j], f[j - cost] + 1);
            }
        }
        return f[n];
    }

    public int numSquares2(int n) {
        int INF = Integer.MAX_VALUE;
        int max = (int) Math.ceil(Math.sqrt(n));

        int[][] f = new int[max + 1][n + 1];
        Arrays.fill(f[0], INF);
        f[0][0] = 0;

        for (int i = 1; i <= max; i++) {
            int cost = i * i;
            for (int j = 1; j <= n; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= cost && f[i][j - cost] != INF) f[i][j] = Math.min(f[i - 1][j], f[i][j - cost] + 1);
            }
        }
        return f[max][n];
    }

}

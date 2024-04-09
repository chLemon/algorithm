package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Kama46 {

    // 01背包问题
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = reader.readLine();
        String[] line1Split = line1.split(" ");
        int M = Integer.parseInt(line1Split[0]);
        int N = Integer.parseInt(line1Split[1]);
        String line2 = reader.readLine();
        String[] line2Split = line2.split(" ");
        int[] spaces = Arrays.stream(line2Split).mapToInt(Integer::valueOf).toArray();
        String line3 = reader.readLine();
        String[] line3Split = line3.split(" ");
        int[] values = Arrays.stream(line3Split).mapToInt(Integer::valueOf).toArray();
        System.out.println(pack2(M, N, spaces, values));
    }

    private static int pack2(int M, int N, int[] spaces, int[] values) {
        int[] dp = new int[N + 1];
        for (int i = 0; i < M; i++) {
            // 这里的j到weight[i]停止就可以了
            for (int j = N; j > 0; j--) {
                dp[j] = j >= spaces[i] ?
                        Math.max(dp[j], dp[j - spaces[i]] + values[i])
                        : dp[j];
            }
        }
        return dp[N];
    }
    
    private static int pack(int M, int N, int[] spaces, int[] values) {
        int[][] dp = new int[M][N + 1];
        // 从spaces[0] 开始遍历就行了
        for (int i = 0; i <= N; i++) {
            dp[0][i] = i >= spaces[0] ? values[0] : 0;
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                // j < weight[i]可以直接赋值 dp[i-1][j]
                int j1 = j - spaces[i];
                dp[i][j] = Math.max(
                        dp[i - 1][j],
                        j1 >= 0 ? dp[i - 1][j1] + values[i] : 0
                );
            }
        }
        return dp[M - 1][N];
    }


}

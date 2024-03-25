package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kama52 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = reader.readLine();
        String[] s1 = line1.split(" ");
        int N = Integer.parseInt(s1[0]);
        int V = Integer.parseInt(s1[1]);
        int[] ws = new int[N];
        int[] vs = new int[N];
        for (int i = 0; i < N; i++) {
            String line = reader.readLine();
            String[] s = line.split(" ");
            ws[i] = Integer.parseInt(s[0]);
            vs[i] = Integer.parseInt(s[1]);
        }

        System.out.println(bag2(N, V, ws, vs));
    }

    private static int bag1(int N, int V, int[] ws, int[] vs) {
        int[][] dp = new int[N + 1][V + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            int cost = ws[i - 1];
            int value = vs[i - 1];
            for (int j = 0; j <= V; j++) {
                dp[i][j] = j >= cost ? Math.max(dp[i - 1][j], value + dp[i][j - cost]) : dp[i - 1][j];
            }
        }
        return dp[N][V];
    }

    private static int bag2(int N, int V, int[] ws, int[] vs) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = ws[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - ws[i]] + vs[i]);
            }
        }
        return dp[V];
    }

}

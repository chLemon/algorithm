package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kama57 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] s = line.split(" ");
        int res = climb(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        System.out.println(res);
    }

    private static int climb(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i - j >= 0) dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }


}

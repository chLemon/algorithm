package _solution.programmercarl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Kama57 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        System.out.println(climb(n, m));
    }

    // 别看成背包，要命
    // f[i] = 求和 (f[i- n])
    // 也就是1 2 爬台阶问题：f[i] = f[i-1] + f[i-2]
    private static int climb(int n, int m) {
        int[] f = new int[n + 1];
        f[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int x = 1; x <= m; x++) {
                if (x <= i) {
                    f[i] += f[i - x];
                }
            }
        }
        System.out.println(Arrays.toString(f));
        return f[n];
    }

}

package tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Read {

    public static void main(String[] args) {
        solve(new int[]{2, 3, 5, 7, 10}, 14);
    }

    public static void solve(int[] arr, int sum) {
        if (sum == 0) return;
        Arrays.sort(arr);
        int n = arr.length;

        boolean[][] f = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            int x = arr[i - 1];
            for (int j = 1; j <= sum; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= x) {
                    f[i][j] = f[i][j] || f[i - 1][j - x];
                }
            }
        }
        for (boolean[] ints : f) {
            System.out.println(Arrays.toString(ints));
        }
        // 倒着输出
        if (!f[n][sum]) {
            System.out.println("没有答案");
        } else {
            List<Integer> res = getRes(f, arr, sum, n);
            System.out.println(res);
        }
    }

    private static List<Integer> getRes(boolean[][] dp, int[] arr, int sum, int n) {
        List<Integer> res = new ArrayList<>();
        int j = sum;
        for (int i = n; i > 1; i--) {
            int x = arr[i - 1];
            if (dp[i - 1][j]) {
                // 如果上面也是true，说明当前数字不需要，也可以
            } else {
                // 当前数字需要，移动j
                res.add(x);
                j -= x;
            }
        }

        return res;
    }


}

package _solution.other;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Kama56 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int C = scanner.nextInt();
        int N = scanner.nextInt();
        int[] ws = new int[N];
        int[] vs = new int[N];
        int[] ks = new int[N];
        for (int i = 0; i < N; i++) {
            ws[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            vs[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            ks[i] = scanner.nextInt();
        }
        int r = bag3(C, N, ws, vs, ks);
        System.out.println(r);
    }

    private static int bag(int capacity, int n, int[] weights, int[] values, int[] ks) {
        int[][] f = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            int weight = weights[i - 1];
            int value = values[i - 1];
            int kMax = ks[i - 1];
            for (int j = 1; j <= capacity; j++) {
                for (int k = 0; k * weight <= j && k <= kMax; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * weight] + k * value);
                }
            }
        }
        return f[n][capacity];
    }

    private static int bag2(int capacity, int n, int[] weights, int[] values, int[] ks) {
        int[] f = new int[capacity + 1];
        for (int i = 1; i <= n; i++) {
            int weight = weights[i - 1];
            int value = values[i - 1];
            int kMax = ks[i - 1];
            for (int j = capacity; j >= 0; j--) {
                for (int k = 0; k * weight <= j && k <= kMax; k++) {
                    f[j] = Math.max(f[j], f[j - k * weight] + k * value);
                }
            }
        }
        return f[capacity];
    }

    // 二进制扁平化，注意：这里想表示10，则必须用 1 + 2 + 4 + 3，这样才能表示1-10内的所有数
    private static int bag3(int capacity, int n, int[] weights, int[] values, int[] ks) {
        List<Integer> newWeights = new ArrayList<>(n);
        List<Integer> newValues = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int w = weights[i];
            int v = values[i];
            int k = ks[i];

            for (int j = 1; j <= k; j *= 2) {
                k -= j;
                newWeights.add(j * w);
                newValues.add(j * v);
            }
            if (k > 0) {
                newWeights.add(k * w);
                newValues.add(k * v);
            }
        }

        // 扁平化完成，用0-1背包解决，这里直接用一维的写了
        int[] f = new int[capacity + 1];
        for (int i = 0; i < newWeights.size(); i++) {
            Integer weight = newWeights.get(i);
            Integer value = newValues.get(i);

            for (int j = capacity; j >= weight; j--) {
                f[j] = Math.max(f[j], f[j - weight] + value);
            }
        }
        return f[capacity];
    }

    private static int bag4(int N, int C, int[] s, int[] v, int[] w) {
        // 扁平化
        List<Integer> worth = new ArrayList<>();
        List<Integer> volume = new ArrayList<>();
        // 我们希望每件物品都进行扁平化，所以首先遍历所有的物品
        for (int i = 0; i < N; i++) {
            // 获取每件物品的出现次数
            int val = s[i];
            // 进行扁平化：如果一件物品规定的使用次数为 7 次，我们将其扁平化为三件物品：1*重量&1*价值、2*重量&2*价值、4*重量&4*价值
            // 三件物品都不选对应了我们使用该物品 0 次的情况、只选择第一件扁平物品对应使用该物品 1 次的情况、只选择第二件扁平物品对应使用该物品 2 次的情况，只选择第一件和第二件扁平物品对应了使用该物品 3 次的情况 ... 
            for (int k = 1; k <= val; k *= 2) {
                val -= k;
                worth.add(w[i] * k);
                volume.add(v[i] * k);
            }
            if (val > 0) {
                worth.add(w[i] * val);
                volume.add(v[i] * val);
            }
        }

        // 0-1 背包问题解决方案
        int[] dp = new int[C + 1];
        for (int i = 0; i < worth.size(); i++) {
            for (int j = C; j >= volume.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - volume.get(i)] + worth.get(i));
            }
        }
        return dp[C];
    }

}

package _solution.leetcode;

import java.util.Arrays;
import java.util.List;

public class No120 {

    // 可以自顶向下，还可以自底向上
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int a = j < 1 ? Integer.MAX_VALUE : f[i - 1][j - 1];
                int b = j >= i ? Integer.MAX_VALUE : f[i - 1][j];
                f[i][j] = Math.min(a, b) + triangle.get(i).get(j);
            }
        }
        for (int[] ints : f) {
            System.out.println(Arrays.toString(ints));
        }
        return Arrays.stream(f[n - 1]).min().orElse(0);
    }

    public int minimumTotal11(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 空间优化
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                int a = j < 1 ? Integer.MAX_VALUE : f[j - 1];
                int b = j >= i ? Integer.MAX_VALUE : f[j];
                f[j] = Math.min(a, b) + triangle.get(i).get(j);
            }
        }
        return Arrays.stream(f).min().orElse(0);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        for (int j = 0; j < n; j++) {
            f[n - 1][j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return f[0][0];
    }

    public int minimumTotal22(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 空间优化
        int[] f = new int[n];
        for (int j = 0; j < n; j++) {
            f[j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                f[j] = Math.min(f[j], f[j + 1]) + triangle.get(i).get(j);
            }
        }
        return f[0];
    }
}

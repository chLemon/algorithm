package _solution.leetcode;

import template.UnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No399 {

    int[] arr;
    double[] weights;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();

        Map<String, Integer> str2Idx = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            str2Idx.put(a, idx++);
            str2Idx.put(b, idx++);
        }

        init(idx);

        // 遍历union
        for (int i = 0; i < n; i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            int aIdx = str2Idx.get(a);
            int bIdx = str2Idx.get(b);
            union(aIdx, bIdx, values[i]);
        }

        // 计算答案
        int r = queries.size();
        double[] res = new double[r];
        for (int i = 0; i < r; i++) {
            List<String> q = queries.get(i);
            Integer a = str2Idx.get(q.get(0));
            Integer b = str2Idx.get(q.get(1));
            res[i] = cal(a, b);
        }
        return res;
    }

    private void init(int size) {
        arr = new int[size];
        weights = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
            weights[i] = 1.0;
        }
    }

    private void union(int a, int b, double v) {
        // v = a / b
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;

        arr[rootA] = rootB;
        weights[rootA] = weights[b] * v / weights[a];
    }

    private int find(int a) {
        if (arr[a] != a) {
            int origin = arr[a];    // 原来的父节点
            arr[a] = find(arr[a]);
            weights[a] = weights[a] * weights[origin];
        }
        return arr[a];
    }

    private double cal(Integer a, Integer b) {
        if (a == null || b == null) return -1;
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) return -1;
        return weights[a] / weights[b];
    }

}

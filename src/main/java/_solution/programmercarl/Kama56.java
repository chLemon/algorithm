package _solution.programmercarl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Kama56 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = reader.readLine().split(" ");
        int C = Integer.parseInt(s1[0]);
        int N = Integer.parseInt(s1[1]);

        int[] weights = new int[N];
        int[] prices = new int[N];
        int[] limits = new int[N];
        String[] ws = reader.readLine().split(" ");
        String[] ps = reader.readLine().split(" ");
        String[] ls = reader.readLine().split(" ");
        for (int i = 0; i < ws.length; i++) {
            weights[i] = Integer.parseInt(ws[i]);
            prices[i] = Integer.parseInt(ps[i]);
            limits[i] = Integer.parseInt(ls[i]);
        }

        System.out.println(bag(C, N, weights, prices, limits));
    }

    private static int bag(int c, int N, int[] weights, int[] prices, int[] limits) {
        List<Integer> newWeights = new ArrayList<>();
        List<Integer> newPrices = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < limits[i]; j++) {
                newWeights.add(weights[i]);
                newPrices.add(prices[i]);
            }
        }
        int n = newWeights.size();

        int[] f = new int[c + 1];
        for (int i = 0; i < n; i++) {
            Integer weight = newWeights.get(i);
            Integer price = newPrices.get(i);
            for (int j = c; j >= weight; j--) {
                f[j] = Math.max(f[j], f[j - weight] + price);
            }
        }

        return f[c];
    }

}

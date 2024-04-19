package programmercarl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kama52 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String l1 = reader.readLine();
        String[] s1 = l1.split(" ");
        int N = Integer.parseInt(s1[0]);
        int V = Integer.parseInt(s1[1]);
        int[] weight = new int[N];
        int[] cost = new int[N];
        for (int i = 0; i < N; i++) {
            String[] s = reader.readLine().split(" ");
            weight[i] = Integer.parseInt(s[0]);
            cost[i] = Integer.parseInt(s[1]);
        }

        System.out.println(bag(N, V, weight, cost));
    }

    private static int bag(int N, int V, int[] weights, int[] costs) {
        int[][] f = new int[N + 1][V + 1];
        // 初始化，0种物品都是0，0个容量都是0

        for (int i = 1; i <= N; i++) {
            int weight = weights[i - 1];
            int cost = costs[i - 1];
            for (int j = 1; j <= V; j++) {
                if (j < weight) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - weight] + cost);
                }
            }
        }

        return f[N][V];
    }

}

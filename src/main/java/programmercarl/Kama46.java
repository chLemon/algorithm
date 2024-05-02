package programmercarl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Kama46 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String l1 = reader.readLine();
        String[] s1 = l1.split(" ");
        String[] s2 = reader.readLine().split(" ");
        String[] s3 = reader.readLine().split(" ");

        System.out.println(bag(
                Integer.parseInt(s1[0]),
                Integer.parseInt(s1[1]),
                Arrays.stream(s2).mapToInt(Integer::parseInt).toArray(),
                Arrays.stream(s3).mapToInt(Integer::parseInt).toArray()
        ));
    }

    private static int bag(int M, int N, int[] spaces, int[] costs) {
        int[][] f = new int[M + 1][N + 1];
        // 初始化，一个都不选，都是0，空间为0，也都是0
        for (int i = 1; i <= M; i++) {
            int space = spaces[i - 1];
            int cost = costs[i - 1];
            for (int j = 1; j <= N; j++) {
                if (j < space) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - space] + cost);
                }
            }
        }
        return f[M][N];
    }


}

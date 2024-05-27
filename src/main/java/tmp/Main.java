package tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int k;
    static int[] vs;
    static int[] ws;

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String l1 = reader.readLine();
//        String[] s1 = l1.split(" ");
//        n = Integer.parseInt(s1[0]);
//        k = Integer.parseInt(s1[1]);
//        vs = new int[n];
//        ws = new int[n];
//        for (int i = 0; i < n; i++) {
//            String line = reader.readLine();
//            String[] ss = line.split(" ");
//            vs[i] = Integer.parseInt(ss[0]);
//            ws[i] = Integer.parseInt(ss[1]);
//        }
//        oddBagDfs(0, 0, 0);
//        System.out.println(maxW);
        n = 3;
        k = 1;
        vs = new int[]{7, 10, 9};
        ws = new int[]{3, 7, 6};
        oddBagDfs(0, 1, 1);
        System.out.println(maxW);
    }

    static int maxW = 0;

    private static void oddBagDfs(int i, int preV, int preW) {
        if (i == n) return;

        // 第i个选和不选

        // 不选
        oddBagDfs(i + 1, preV, preW);

        // 选
        int v = preV & vs[i];
        int w = preW & ws[i];
        if (v <= k) {
            maxW = Math.max(maxW, w);
        }
        oddBagDfs(i + 1, v, w);
    }
}

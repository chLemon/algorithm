package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while ((s = br.readLine()) != null) {
                String[] inputs = s.split(" ");
                int M = Integer.parseInt(inputs[0]);
                int N = Integer.parseInt(inputs[1]);

                int[][] ints = no2(M, N);
                StringBuilder sb = new StringBuilder();
                sb.append("[");
//            System.out.print("[");
                for (int i = 0; i < ints.length; i++) {
                    sb.append("[");
//                System.out.print("[");
//                System.out.print(ints[i][0] + "," + ints[i][1]);
                    sb.append(ints[i][0] + "," + ints[i][1]);
                    if (i == ints.length - 1) {
                        sb.append("]");
//                    System.out.print("]");
                    } else {
                        sb.append("],");
//                    System.out.print("],");
                    }
                }
                sb.append("]");
//            System.out.println("]");
                System.out.println(sb.toString());
            }
        }catch (Exception e){
            System.out.println("[]");
        }

    }

    public static int[][] no2(int M, int N) {
        if (M < 10 || M > 1000 || N < 10 || N > 1000) {
            return new int[][]{};
        }
        int l = 0, r = N - 1, t = 0, b = M - 1;
        int count = 0;
        ArrayList<int[]> resultArray = new ArrayList<>();

        while (true) {
            for (int i = l; i <= r; i++) {
                // left to right.
                count++;
                if (judge(count)) {
                    resultArray.add(new int[]{t, i});
                }
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                // top to bottom.
                count++;
                if (judge(count)) {
                    resultArray.add(new int[]{i, r});
                }
            }
            if (l > --r) break;
            for (int i = r; i >= l; i--) {
                // right to left.
                count++;
                if (judge(count)) {
                    resultArray.add(new int[]{b, i});
                }
            }
            if (t > --b) break;
            for (int i = b; i >= t; i--) {
                // bottom to top.
                count++;
                if (judge(count)) {
                    resultArray.add(new int[]{i, l});
                }
            }
            if (++l > r) break;
        }
        int[][] result = new int[resultArray.size()][];
        for (int i = 0; i < resultArray.size(); i++) {
            result[i] = resultArray.get(i);

        }
        return result;
    }

    public static boolean judge(int count) {
        //个位数为7
        if (count % 10 != 7) {
            return false;
        } else {
            //十位数为奇数
            int temp = count / 10;
            return ((temp & 1) == 0) ? false : true;
        }
    }
}

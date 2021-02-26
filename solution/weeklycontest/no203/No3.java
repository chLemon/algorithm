package weeklycontest.no203;

import org.junit.Test;

public class No3 {

    public int findLatestStep(int[] arr, int m) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        for (int i = 0; i < m; i++) {
            sb.append("1");
        }
        sb.append("0");
        String target = sb.toString();

        char[] parent = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            parent[i] = '1';
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            String s = "0" + String.valueOf(parent) + "0";
            if (s.contains(target)) {
                return i + 1;
            }
            parent[arr[i]-1] = '0';
        }
        return -1;
    }

    @Test
    public void test() {

        int i = findLatestStep(new int[]{3, 5, 1, 2, 4}, 1);
        System.out.println(i);

    }

}

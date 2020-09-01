package zhousai823;

import org.junit.Test;

import java.util.Arrays;

public class No2 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int result = 0;

        int i = 0, j = piles.length - 2, k = piles.length - 1;
        while (i < j) {
            result += piles[j];
            i++;
            j -= 2;
            k -= 2;
        }

        return result;
    }

    @Test
    public void test() {
        int[] a = new int[]{4, 5, 6};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }

    }

}

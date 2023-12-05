package temp;

import org.junit.jupiter.api.Test;

public class CommonTest {

    public static double f(int n, int k) {
        return Math.pow(2, n - k) + (n - k - 1) * Math.pow(2, n - k - 2);
    }

    @Test
    public void test() {
        helper(4, 4);
        helper(5, 2);
        helper(20, 1);
    }

    static void helper(int n, int k) {
        System.out.println(f(n, k));
    }
}

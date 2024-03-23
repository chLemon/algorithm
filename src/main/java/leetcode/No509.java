package leetcode;

public class No509 {
    public static void main(String[] args) {
        No509 no = new No509();
        no.fib(2);
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int lastLast = 0;
        int last = 1;
        int res = 0;
        for (int i = 2; i < n + 1; i++) {
            res = lastLast + last;
            lastLast = last;
            last = res;
        }
        return res;
    }

    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        int[] helper = new int[n + 1];
        helper[0] = 0;
        helper[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            helper[i] = helper[i - 1] + helper[i - 2];
        }
        return helper[n + 1];
    }

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib2(n - 1) + fib2(n - 2);
    }

}

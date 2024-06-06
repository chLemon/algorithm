package _solution.leetcode;

class No50 {
    public static void main(String[] args) {
        System.out.println(new No50().myPow(2.0, -2147483648));
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double res = 1;
        long b = n; // 因为n有 Integer.MIN_VALUE，直接取反，会溢出
        if (n < 0) {
            x = 1 / x;
            b = -b; // 这里也必须是-b，不能用-n
        }

        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

}

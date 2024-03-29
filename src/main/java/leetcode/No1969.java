package leetcode;

public class No1969 {


    long mod = 1000_000_007L;

    public static void main(String[] args) {
        No1969 no = new No1969();
        no.minNonZeroProduct(31);
        no.minNonZeroProduct2(31);
    }

    public int minNonZeroProduct(int p) {
        // (2^p - 2) ^ (2^(p-1) -1 ) * (2^p - 1)
        long x = fastPow(2, p) - 2;
        // ！！！！！！！！！！！！！！！！！！！这里，y不能取模！！！！！！！！！！！1
        long y = fastPow(2, p - 1) - 1;
        long z = fastPow(2, p) - 1;
        System.out.println("1  base: " + x + " n: " + y);
        long l = fastPow(x, y);
        System.out.println("before * x1" + l);
        return (int) (l * z % mod);
    }

    public long fastPow(long x, long n) {
        long res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return res % mod;
    }

    public int minNonZeroProduct2(int p) {
        if (p == 1) {
            return 1;
        }
        long mod = 1000000007;
        long x = fastPow2(2, p, mod) - 1;
        long y = (long) 1 << (p - 1);
        long base = x - 1;
        long n = y - 1;
        System.out.println("2  base: " + base + " n: " + n);
        long be = fastPow2(base, n, mod);
        System.out.println("before * x2" + be);
        return (int) (be * x % mod);
    }

    public long fastPow2(long x, long n, long mod) {
        long res = 1;
        for (; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
        }
        return res;
    }
}

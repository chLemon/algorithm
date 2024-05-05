package _solution.inf;

class No2466 {

    public static void main(String[] args) {
        new No2466().countGoodStrings(3, 3, 1, 1);
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007;
        mod = (int) 1e9 + 7;

        long[] f = new long[high + 1];
        f[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                f[i] += f[i - zero];
                f[i] %= mod;
            }
            if (i >= one) {
                f[i] += f[i - one];
                f[i] %= mod;
            }
        }

        int res = 0;
        for (int i = low; i <= high; i++) {
            res += f[i];
            res %= mod;
        }
        return res;
    }

}

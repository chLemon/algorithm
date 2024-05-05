package _solution.contest.biweekly.w129;

class No3 {

    public static void main(String[] args) {
        System.out.println(new No3().numberOfStableArrays(3, 3, 2));
    }

    int mod = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        long total = cal(zero + one) / cal(zero) / cal(one);
        long minus1 = one <= limit ? 0 :
                cal(one + zero - limit) / cal(one - limit) / cal(zero) - 1;
        long minus2 = zero <= limit ? 0 :
                cal(one + zero - limit) / cal(one) / cal(zero - limit);
        return (int) ((total - minus1 - minus2) % mod) - 1;
    }

    private long cal(int a) {
        if (a < 1) {
            return 1;
        }
        long res = 1;
        for (int i = 1; i <= a; i++) {
            res = (i % mod) * (res) % mod;
        }
        return res % mod;
    }
}

package _solution.programmercarl;

class No343 {

    public static void main(String[] args) {
        No343 no = new No343();
        no.integerBreak(10);
    }

    public int integerBreak(int n) {
        // k 不重要
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 0;
        // f[i] = j * f[i - j] || j * (i - j)
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                f[i] = Math.max(f[i], Math.max(j * f[i - j], j * (i - j)));
            }
        }
        return f[n];
    }

}

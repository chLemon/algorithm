package leetCode;

public class No50 {
    public double myPow(double x, int n) {
        if (n == 0 || x == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        if (n == 2) {
            return x * x;
        }
        if (n < 0) {
            return 1 / x / myPow(x, -n - 1);
        }
        double temp = myPow(x, n / 2);
        return (n & 1) == 0 ? temp * temp : temp * temp * x;
    }
}

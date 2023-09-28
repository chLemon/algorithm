package solutions.codinginterviews;

import org.junit.Test;

public class No16 {
    /*
    实现函数double Power(double base, int exponent)，
    求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
     */
    /*
    说明:
    -100.0 < x < 100.0
    n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
     */
    public double myPow(double x, int n) {
        long t = n;
        if (x == 0) {
            //0的0次方也在这里了
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        double result = 1;
        if (t < 0) {
            x = 1 / x;
            t = -t;
        }
        //判断n是偶数还是奇数：
        while (t > 0) {
            if ((t & 1) == 1) {
                //n是奇数
                result = result * x;
            }
            x = x * x;
            t = t / 2;

        }
        return result;

    }

    @Test
    public void test() {
        double v = myPow(5, 5);
        System.out.println(v);
    }

}

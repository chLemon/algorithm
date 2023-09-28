package solutions.codinginterviews;

import org.junit.Test;

public class No14_2 {
    /*
    给你一根长度为 n 的绳子，
    请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
    每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
    请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
    例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
    此时得到的最大乘积是18。
    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */

    /*
    这个题最麻烦的就是取模：
    (a + b) % p = (a % p + b % p) % p （1）
    (a - b) % p = (a % p - b % p ) % p （2）
    (a * b) % p = (a % p * b % p) % p （3）
    a ^ b % p = ((a % p)^b) % p （4）
     */
    static int m = 1000000007;

    public int cuttingRope(int n) {
        /*  提示：     2 <= n <= 1000       */
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        long result = 1;
        if (n % 3 == 0) {
            result= pow3(n / 3);
        } else if (n % 3 == 1) {
            result= pow3(n / 3 - 1) * 4L % m;
        } else {
            result= pow3(n / 3) * 2 % m;
        }
        return (int) result;
    }

    public int pow3(int a) {
        long result = 1;
        for (int i = 0; i < a; i++) {
            result = (3 * (result % m)) % m;
        }
        System.out.println(result);
        return (int) result;
    }

    @Test
    public void Test() {
        /*
        输入: 2
        输出: 1
        解释: 2 = 1 + 1, 1 × 1 = 1

        输入: 10
        输出: 36
        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
         */

        System.out.println(cuttingRope(127));

    }
}

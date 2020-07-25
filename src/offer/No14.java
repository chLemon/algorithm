package offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class No14 {
    /*
    给你一根长度为 n 的绳子，
    请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
    每段绳子的长度记为 k[0],k[1]...k[m-1] 。
    请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
    例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
    此时得到的最大乘积是18。
     */

    /*提示：      2 <= n <= 58       */
    HashMap map = new HashMap<Integer, Integer>();

    //可以直接用一个数组，没必要hashmap
    public int cuttingRope(int n) {
        int max = 1;
        for (int i = 1; i <= n / 2; i++) {
            int t = multi(i) * multi(n - i);
            if (max < t) {
                max = t;
            }
        }
        return max;
    }

    public int multi(int n) {

        if (map.get(n) != null) {
            return (int) map.get(n);
        }
        int max = n;
        for (int i = 1; i <= n / 2; i++) {
            int t = multi(i) * multi(n - i);
            if (max < t) {
                max = t;
            }
        }
        map.put(n, max);
        return max;
    }

    public int cuttingRope2(int n) {
        if (n < 4) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        } else {
            return (int) (Math.pow(3, a) * b);
        }//少考虑了1的情况，*4
    }

    @Test
    public void test() {
            /*
            示例 1：

        输入: 2
        输出: 1
        解释: 2 = 1 + 1, 1 × 1 = 1
        示例 2:

        输入: 10
        输出: 36
        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36

             */
        System.out.println(cuttingRope(4));
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope(29));
    }
}

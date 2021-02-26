package weeklycontest.no201;

import org.junit.Test;

public class No2 {
    /*
    给你两个正整数 n 和 k，二进制字符串  Sn 的形成规则如下：

    S1 = "0"
    当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
    其中 + 表示串联操作，
    reverse(x) 返回反转 x 后得到的字符串，
    而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）

    例如，符合上述描述的序列的前 4 个字符串依次是：

    S1 = "0"
    S2 = "011"
    S3 = "0111001"
    S4 = "011100110110001"
    请你返回  Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内.
     */

    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int length = (int) (Math.pow(2, n) - 1);
        if (k - 1 == length / 2) {
            //恰好是中间
            return '1';
        } else if (k - 1 > length / 2) {
            //右侧
            return inverse(findKthBit(n - 1, length + 1 - k));
        } else {
            //左侧
            return findKthBit(n - 1, k);
        }
    }

    public char inverse(char c) {
        if (c == '0') {
            return '1';
        } else {
            return '0';
        }
    }

    @Test
    public void test() {
        findKthBit(3, 1);
    }
}

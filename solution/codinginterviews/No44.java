package codinginterviews;

import org.junit.Test;

public class No44 {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int p, q = 0;
        int temp = n;
        while (temp != 0) {
            q++;
            temp /= 10;
        }
        //q就是当前n的阶数，m不是q就是q+1，算一下范围
        long qLB = lowBorder(q);
        p = qLB <= n ? q : q - 1;
        //拿到了真实的p
        long pLB = lowBorder(p);
        int bias = (int) ((n - pLB) / p);
        int number = (int) (Math.pow(10, p - 1) + bias);
        int first = (int) (bias * p + pLB);
        int l = n - first;
        //l是0就是最高位，1就是次高位
        return number / (int) Math.pow(10, p - 1 - l) % 10;
    }

    public long lowBorder(int p) {
        if (p == 1) {
            return 1;
        }
        return (long) ((Math.pow(10, p - 1) - Math.pow(10, p - 2)) * (p - 1) + lowBorder(p - 1));
    }

    @Test
    public void test() {
        System.out.println(findNthDigit(2147483647));
        System.out.println(findNthDigit2(1000000000));
    }

    public int findNthDigit2(int n) {
        int digit = 1;
        int start = 1;
        int count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

}

package sword_to_offer;

class No09 {
    /*
    写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
    斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

     */

    /*
    很经典的问题，左脚踩右脚。g=g+f,f=g-f
     */
    public static int fib(int n) {

        int a = 0;
        int b = 1;
        int sum = 0;
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }

        for (int i = 2; i <= n; i++) {
            sum = (a + b)%1000000007;
            //a<b
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 48; i++) {
            int fib = fib(i);
            System.out.println("f"+i+"="+fib);
        }

    }

}

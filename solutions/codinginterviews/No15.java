package codinginterviews;

import org.junit.Test;

public class No15 {
    /*
    请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
    例如，把 9 表示成二进制是 1001，有 2 位是 1。
    因此，如果输入 9，则该函数输出 2。
     */

    public int hammingWeight(int n) {
        //方法1，右移与1

//        int count = 0;
//        while (n != 0) {
//            if ((n & 1) == 1) {
//                count++;
//            }
//            n = n >>> 1;
//        }
//        return count;


        //方法2：n与n-1
        int count=0;
        while (n!=0){
            count++;
            n=n&(n-1);
        }
        return count;

    }
    @Test
    public void test(){
        int i = hammingWeight(0b11111111111111111111111111111101);
        System.out.println(i);
    }


}

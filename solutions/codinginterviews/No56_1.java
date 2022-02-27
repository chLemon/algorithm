package codinginterviews;

import org.junit.Test;

public class No56_1 {
    /*
    一个整型数组 nums 里除两个数字之外，
    其他数字都出现了两次。
    请写程序找出这两个只出现一次的数字。
    要求时间复杂度是O(n)，空间复杂度是O(1)。
     */
    public int[] singleNumbers(int[] nums) {
        /*
        异或：
        0 xor 0=0
        0 xor 1=1
        0异或任何数，都是那个数本身

        a xor a=0
        一个数异或自己，得0
        异或满足交换律和结合律

        ^  异或

        k&(-k) 可以轻松获得最低位的1
         */
        int p = 0;
        for (int num : nums) {
            p ^= num;
        }
        int mask = p & (-p);
        int i = 0;
        int j = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                i ^= num;
            } else {
                j ^= num;
            }
        }
        return new int[]{i, j};
    }

    @Test
    public void test() {

    }

}

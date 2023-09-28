package solutions.leetcode;

import org.junit.Test;

public class No300 {
    /*
    给定一个无序的整数数组，
    找到其中最长上升子序列的长度。
     */

    /*
    输入: [10,9,2,5,3,7,101,18]
    输出: 4
    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];

        int result = 0;
        for (int num : nums) {
            int i = 0;
            int j = result;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m]<num){
                    i=m+1;
                }else{
                    
                }

            }

        }
return 0;
    }

    @Test
    public void test() {
        int i = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        int i2 = lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9});
        System.out.println(i2);
    }

}

package _solution.inf;

import java.util.Arrays;

class No611 {

    public static void main(String[] args) {
        No611 no = new No611();
        no.triangleNumber(new int[]{4, 2, 3, 4});
    }

    public int triangleNumber(int[] nums) {
        // 两边之和大于第三边（2个小的和 > 最长的），两边之差小于第三边（最长-最短 < 中间的）
        /*
        3个数，不重复的下标，顺序无所谓，只要个数。假定，1 <= a <= b <= c ，则三角形条件为
        a + b > c
        即找到2个数的和，大于第3个数
         */
        int count = 0;
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum > nums[i]) {
                    count += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return count;
    }

}

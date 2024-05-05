package _solution.leetcode;

import java.util.Arrays;

class No45 {

    public static void main(String[] args) {
        No45 no = new No45();
        no.jump2(new int[]{2, 3, 1, 1, 4});
    }

    public int jump(int[] nums) {
        int[] f = new int[nums.length];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[nums.length - 1];
    }

    public int jump2(int[] nums) {
        int count = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;    // 下一次起跳范围起点
            end = maxPos + 1;
            count++;
        }
        return count;
    }
}

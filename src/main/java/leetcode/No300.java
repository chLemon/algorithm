package leetcode;

import java.util.Arrays;

public class No300 {

    public static void main(String[] args) {
        No300 no = new No300();
        no.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
    }

    public int lengthOfLIS(int[] nums) {
        // 定义，以nums[i]结尾的最长子序列长度
        int[] f = new int[nums.length];
        f[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            // f[i] = 前面所有 < num 的长度中的最大值 + 1
            int num = nums[i];
            int l = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < num) l = Math.max(l, f[j]);
            }
            f[i] = l + 1;
        }
        return Arrays.stream(f).max().orElse(1);
    }

}

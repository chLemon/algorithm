package programmercarl;

import java.util.Arrays;

public class No416 {

    public static void main(String[] args) {
        new No416().canPartition(new int[]{1, 5, 11, 5});
    }

    public boolean canPartition(int[] nums) {
        // 挑选出一部分元素使得和为 sum / 2
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) return false;
        int target = sum / 2;

        // f[i] 表示选择 和 <= i 的数，能选出来的最大值
        int[] f = new int[target + 1];
        for (int n : nums) {
            for (int i = f.length - 1; i >= n; i--) {
                f[i] = Math.max(f[i], f[i - n] + n);
            }
        }
        return f[target] == target;
    }

}

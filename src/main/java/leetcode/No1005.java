package leetcode;

import java.util.Arrays;

public class No1005 {
    public static void main(String[] args) {
        No1005 no = new No1005();
        no.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        // 根据绝对值排序
        int[] sorted = Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> Integer.compare(Math.abs(b), Math.abs(a)))
                .mapToInt(Integer::intValue)
                .toArray();
        for (int i = 0; i < sorted.length; i++) {
            if (k == 0) {
                break;
            }
            if (sorted[i] < 0 && k > 0) {
                sorted[i] = -sorted[i];
                k--;
            }
        }
        if ((k & 1) == 1) {
            sorted[sorted.length - 1] = -sorted[sorted.length - 1];
        }
        return Arrays.stream(sorted).sum();
    }

}

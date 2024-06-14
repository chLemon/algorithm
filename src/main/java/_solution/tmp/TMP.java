package _solution.tmp;

import java.util.Random;

public class TMP {

    Random ran = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int kthLargest = new TMP().findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // k处理成 排序好后的下标值
        return partition(nums, n - k, 0, n - 1);
    }

    private int partition(int[] nums, int k, int left, int right) {
        if (left == right) return nums[left];
        int r = left + ran.nextInt(right - left + 1);
        swap(nums, left, r);
        int x = nums[left]; // 轴点
        // L G= U
        // [left + 1, m)[m, i) [i, right]
        int m = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < x) {
                // 加入L
                swap(nums, m++, i);
            }   // 加入G
        }
        // x 与 m - 1 交换位置
        swap(nums, left, m - 1);

        // m - 1 处是轴点， [left, m - 1] m - 1是第 m 小的数
        if (k == m - 1) {
            return x;
        } else if (k < m - 1) {
            return partition(nums, k, left, m - 2);
        } else {    // k > m
            return partition(nums, k, m, right);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

}

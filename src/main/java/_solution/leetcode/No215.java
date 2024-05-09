package _solution.leetcode;

import java.util.Random;

public class No215 {
    int[] nums;
    int n;
    Random random = new Random();

    // 直接建堆，O(n) 但是选k个，k * logn

    public static void main(String[] args) {
        new No215().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }

    // 快排变种 k-select 期望O(n)
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.n = nums.length;

        return partition(0, n - 1, n - k);
    }

    private int partition(int l, int r, int k) {
        if (l == r) return nums[l];
        // 从 l - r 里随机选一个，作为轴点
        int candidateIndex = l + random.nextInt(r - l + 1);
        swap(l, candidateIndex);

        // LGU
        int x = nums[l];
        int m = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < x) {
                swap(nums[++m], nums[i]);
            }
        }
        swap(nums[l], nums[m]);
        // low 就是 轴点
        if (m == k) return nums[m];
        if (m > k) return partition(l, m - 1, k);
        return partition(m + 1, r, k - m - 1);
    }

    private void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}

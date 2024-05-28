package _solution.leetcode;

import java.util.Random;

class No215 {
    public static void main(String[] args) {
        System.out.println(new No215().findKthLargest(new int[]{6, 2, 1, 5, 3, 4}, 2));
    }

    int[] nums;
    int n;
    Random random = new Random(System.currentTimeMillis());

    // 直接建堆，O(n) 但是选k个，k * logn

    // 快排quicksort 变种 k-select 期望O(n)
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.n = nums.length;

        // 第k大的下标为 n - k
        return partition(0, n - 1, n - k);
    }

    // partition 语义: 让 轴点归位。即 轴点下标为已排序好的 
    private int partition(int l, int r, int k) {
        if (l == r) return nums[l];
        // 从 l - r 里随机选一个，作为轴点
//        int candidateIndex = l + random.nextInt(r - l + 1);
//        swap(l, candidateIndex);

        // LGU
        int x = nums[l];
        int m = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < x) {
                swap(++m, i);
            }
        }
        swap(l, m);
        // low 就是 轴点
        if (m == k) return nums[m];
        if (m > k) return partition(l, m - 1, k);
        return partition(m + 1, r, k);
    }

    private void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // 霍尔分区方案
    int qselect(int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(i, j);
        }
        if (k <= j) return qselect(l, j, k);
        else return qselect(j + 1, r, k);
    }

}

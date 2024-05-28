package temp;

import java.util.Random;

public class Test {

    Random random = new Random(System.currentTimeMillis());
    int[] nums;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Test().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        // 第k大的下标为 n - k
        return partition(0, n, n - k);
    }

    /**
     * @return res
     * @param: [)
     */
    private int partition(int left, int right, int k) {
        if (left + 1 == right) return nums[left];
        int r = random.nextInt(right - left);
        swap(left, r + left);

        int x = nums[left];
        int m = left;
        // L G U
        // L : (left, m]
        // G : (m, i)
        // U : [i, right)
        for (int i = left + 1; i < right; i++) {
            if (nums[i] < x) {
                swap(++m, i);
            }
        }
        swap(left, m);
        // m 归位
        if (m == k) return nums[m];
        if (m < k) {
            return partition(left, m, k);
        }
        return partition(m + 1, right, k);
    }


    private void swap(int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}

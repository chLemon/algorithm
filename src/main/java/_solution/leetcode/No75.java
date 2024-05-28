package _solution.leetcode;

public class No75 {

    public void sortColors(int[] nums) {
        // [0, p) 0
        // [p, i) 1
        // [q, n) 2
        // [i, q) 未知
        int n = nums.length;
        int p = 0;
        int q = n;
        for (int i = 0; i < q; ) {
            int x = nums[i];
            if (x == 0) {
                swap(nums, p, i);
                p++;
                i++;
            } else if (x == 1) {
                i++;
            } else {
                q--;
                swap(nums, i, q);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }
}

    
}

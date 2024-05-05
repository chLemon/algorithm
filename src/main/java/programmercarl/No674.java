package programmercarl;

import java.util.Arrays;

class No674 {

    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];

        f[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                f[i] = f[i - 1] + 1;
            } else {
                f[i] = 1;
            }
        }
        return Arrays.stream(f).max().orElse(1);
    }

}

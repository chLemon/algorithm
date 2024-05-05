package programmercarl;

import java.util.Arrays;

class No300 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];

        /*
        f[i] = for n < ni (f[n]) + 1
         */
        Arrays.fill(f, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        return Arrays.stream(f).max().orElse(1);
    }

}

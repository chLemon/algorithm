package inf;

class No377 {

    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];

        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int x : nums) {
                if (x <= i) {
                    f[i] += f[i - x];
                }
            }
        }
        return f[target];
    }

}

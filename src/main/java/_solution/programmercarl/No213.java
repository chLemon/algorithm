package _solution.programmercarl;

class No213 {

    public int rob(int[] nums) {
        // 偷第一个房子,则第二个和最后一个不能偷
        int r1 = rob(nums, 2, nums.length - 2) + nums[0];

        // 不偷第一个房子
        int r2 = rob(nums, 1, nums.length - 1);

        return Math.max(r1, r2);
    }


    private int rob(int[] nums, int start, int end) {
        if (end - start < 0) return 0;
        int[] f = new int[nums.length];
        f[start] = nums[start];
        for (int i = start + 1; i <= end; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
        }
        return f[end];
    }

}

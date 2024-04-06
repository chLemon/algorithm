package leetcode;

class No213 {
    public int rob(int[] nums) {
        // dp数组上包含个0，会好很多
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int a = helper(nums, 0, nums.length - 1);
        int b = helper(nums, 1, nums.length);
        return Math.max(a, b);
    }

    public int helper(int[] nums, int i, int j) {
        int cur = 0;
        int pre = 0;
        for (int k = i; k < j; k++) {
            int result = Math.max(cur, pre + nums[k]);
            pre = cur;
            cur = result;
        }
        return cur;
    }

    public void test() {
        int rob = rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }
}

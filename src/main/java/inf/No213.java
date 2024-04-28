package inf;

public class No213 {

    public static void main(String[] args) {
        System.out.println(new No213().rob(new int[]{2, 3, 2}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        // 分类讨论
        // 如果偷 nums[0]，则 nums[1]和nums[n-1]都不能偷，问题转换为  nums[2] - nums[n-2] 的最大值
        int rob0 = rob(nums, 2, n - 2) + nums[0];
        // 如果不偷 nums[0]，则 nums[1] - nums[n-1]
        int rob1 = rob(nums, 1, n - 1);
        return Math.max(rob0, rob1);
    }

    private int rob(int[] nums, int start, int end) {
        if (start > end) return 0;
        int n = end - start + 1;
        int[] f = new int[n + 1];
        f[1] = nums[start];
        for (int i = 2; i <= n; i++) {
            int x = nums[start + i - 1];
            f[i] = Math.max(f[i - 1], f[i - 2] + x);
        }
        return f[n];
    }

}

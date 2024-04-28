package inf;

public class No198 {


    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1];
        f[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            int x = nums[i - 1];
            f[i] = Math.max(f[i - 1], f[i - 2] + x);
        }
        return f[n];
    }


}

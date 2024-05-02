package programmercarl;

class No53 {

    public static void main(String[] args) {
        No53 no = new No53();
        no.maxSubArray(new int[]{-1});
    }

    public int maxSubArray(int[] nums) {
        // dp f[i]: 以i结尾的和最大连续子数组，至少包含一个
        int[] f = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            int x = nums[i - 1];
            f[i] = f[i - 1] >= 0 ? f[i - 1] + x : x;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < f.length; i++) {
            max = Math.max(max, f[i]);
        }
        return max;
    }

}

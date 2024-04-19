package tmp;

class Anyway {

    public static void main(String[] args) {
        System.out.println(cal(null));
    }

    private static int[][] cal(int[] nums) {
        int n = nums.length;

        int max = Math.max(nums[n - 1], nums[n - 2]);
        int subMax = Math.min(nums[n - 1], nums[n - 2]);

        int[][] ans = new int[nums.length - 2][2];
        for (int i = nums.length - 3; i >= 0; i--) {
            ans[i] = new int[]{max, subMax};

            // max subMax更新
            if (nums[i] > subMax) {
                max = Math.max(max, nums[i]);
                subMax = Math.min(max, nums[i]);
            }
        }
        return ans;
    }


}

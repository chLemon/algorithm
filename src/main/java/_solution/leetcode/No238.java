package _solution.leetcode;

class No238 {

    public static void main(String[] args) {
        new No238().productExceptSelf(new int[]{1, 2, 3, 4});
    }


    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preProduct = new int[n];
        int[] suffixProduct = new int[n];
        preProduct[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preProduct[i] = preProduct[i - 1] * nums[i];
        }
        suffixProduct[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int preP = i - 1 >= 0 ? preProduct[i - 1] : 1;
            int sufP = i + 1 < n ? suffixProduct[i + 1] : 1;
            res[i] = preP * sufP;
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i];
        }

        int pre = 1;
        for (int i = 0; i < n; i++) {
            int s = i + 1 < n ? suf[i + 1] : 1;
            suf[i] = s * pre;
            pre = pre * nums[i];
        }
        return suf;
    }
}

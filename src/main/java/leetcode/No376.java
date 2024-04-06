package leetcode;

class No376 {
    public static void main(String[] args) {
        No376 no = new No376();
        int i = no.wiggleMaxLength(new int[]{1, 2, 2, 3});
    }

    public int wiggleMaxLength2(int[] nums) {
        int pre = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int now = nums[i] - nums[i - 1];
            if (now * pre < 0 || (pre == 0 && now != 0)) {
                count++;
            }
            if (now != 0) {
                pre = now;
            }
        }
        return count;
    }


    public int wiggleMaxLength(int[] nums) {
        int[][] f = new int[nums.length][2];

        f[0][0] = 1;
        f[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff > 0) {
                f[i][0] = f[i - 1][1] + 1;
                f[i][1] = f[i - 1][1];
            } else if (diff < 0) {
                f[i][0] = f[i - 1][0];
                f[i][1] = f[i - 1][0] + 1;
            } else {
                f[i][0] = f[i - 1][0];
                f[i][1] = f[i - 1][1];
            }
        }
        return Math.max(f[nums.length - 1][0], f[nums.length - 1][1]);
    }
}

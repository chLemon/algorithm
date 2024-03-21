package leetcode;

public class No376 {
    public static void main(String[] args) {
        No376 no = new No376();
        int i = no.wiggleMaxLength2(new int[]{3, 3, 3, 2, 5});
    }

    public int wiggleMaxLength2(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
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

}

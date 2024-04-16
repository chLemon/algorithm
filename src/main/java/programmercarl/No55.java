package programmercarl;

public class No55 {

    public boolean canJump(int[] nums) {
        int maxIndex = nums[0];
        int i = 1;
        for (; i < nums.length && i <= maxIndex; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return i == nums.length;
    }

}

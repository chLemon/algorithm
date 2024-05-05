package _solution.leetcode;

class No283 {

    // 这个题用for写更清晰
    public void moveZeroes(int[] nums) {
        int fill = 0;
        int move = 0;
        while (move < nums.length) {
            while (move < nums.length && nums[move] == 0) {
                move++;
            }
            if (move >= nums.length) break;
            if (move != fill) nums[fill] = nums[move];
            fill++;
            move++;
        }
        while (fill < nums.length) {
            nums[fill++] = 0;
        }
    }

}

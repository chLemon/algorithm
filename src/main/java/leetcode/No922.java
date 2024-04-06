package leetcode;

class No922 {

    public int[] sortArrayByParityII(int[] nums) {
        int findOddInEven = 0;
        int findEvenInOdd = 1;
        while (findOddInEven < nums.length && findEvenInOdd < nums.length) {
            while (findOddInEven < nums.length && (nums[findOddInEven] & 1) == 0) {
                findOddInEven += 2;
            }
            while (findEvenInOdd < nums.length && (nums[findEvenInOdd] & 1) == 1) {
                findEvenInOdd += 2;
            }
            if (findOddInEven >= nums.length || findEvenInOdd >= nums.length) {
                break;
            }
            // 交换
            int tmp = nums[findOddInEven];
            nums[findOddInEven] = nums[findEvenInOdd];
            nums[findEvenInOdd] = tmp;
            findOddInEven += 2;
            findEvenInOdd += 2;
        }
        return nums;
    }

}

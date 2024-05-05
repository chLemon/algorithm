package _solution.sword_to_offer;

class No53_2 {
    /*
    一个长度为n-1的递增排序数组中的所有数字都是唯一的，
    并且每个数字都在范围0～n-1之内。
    在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，
    请找出这个数字。
     */
    public int missingNumber(int[] nums) {
        int lo = 0;
        int hi = nums.length;
        int mi = 0;
        while (lo < hi) {
            mi = lo + (hi - lo) / 2;

            if (nums[mi] == mi) {
                //在右边
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return hi;
    }
}

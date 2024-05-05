package _solution.sword_to_offer;

class No56_2 {
    public int singleNumber(int[] nums) {
        //还有个思路：建一个32位数组，把每一位都加上去，出现三次的，那一位必定是3的倍数

//        int ones = 0, twos = 0;
//        for(int num : nums){
//            ones = ones ^ num & ~twos;
//            twos = twos ^ num & ~ones;
//        }
//        return ones;

        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;

    }
}

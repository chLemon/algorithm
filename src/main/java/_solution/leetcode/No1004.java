package _solution.leetcode;

class No1004 {

    public static void main(String[] args) {
        No1004 no = new No1004();
        int i = no.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        System.out.println(i);
    }

    public int longestOnes(int[] nums, int k) {
        // 窗口内k个0
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left++] == 0) {
                    zeroCount--;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return zeroCount;
    }

}

package programmercarl;

class No45 {
    public static void main(String[] args) {
        No45 no = new No45();
        no.jump(new int[]{2, 1});
    }

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int count = 0;
        int maxIndex = nums[0];
        int i = 1;
        while (i < nums.length) {
            count++;
            int curMaxIndex = maxIndex;
            for (int j = i; j <= maxIndex && j < nums.length; j++) {
                curMaxIndex = Math.max(curMaxIndex, nums[j] + j);
            }
            // 这一轮能抵达的最远值，下一跳从 maxIndex + 1 开始考虑
            i = maxIndex + 1;
            if (maxIndex == curMaxIndex) {
                break;
            }
            maxIndex = curMaxIndex;
        }
        return count;
    }

}

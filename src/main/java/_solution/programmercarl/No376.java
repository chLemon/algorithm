package _solution.programmercarl;

class No376 {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return 1;

        int count = 1;
        Boolean trend = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            boolean thisTrend = nums[i] > nums[i - 1];
            if (trend == null) {
                trend = thisTrend;
                count++;
            } else {
                if (trend != thisTrend) {
                    trend = thisTrend;
                    count++;
                }
            }
        }
        return count;
    }

}

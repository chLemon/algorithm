package inf;

class No2962 {

    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (max < num) {
                max = num;
                maxCount = 1;
            } else if (max == num) {
                maxCount++;
            }
        }
        if (maxCount < k) return 0;

        long res = 0;
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                count++;
            }
            while (count >= k) {
                if (nums[left++] == max) {
                    count--;
                }
            }
            res += left;
        }
        return res;
    }

}

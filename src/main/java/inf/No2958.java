package inf;

import java.util.HashMap;
import java.util.Map;

class No2958 {

    public int maxSubarrayLength(int[] nums, int k) {
        int maxLen = 0;
        int left = 0;
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            // 下面这一大串还可以这么写：
            /*
            numCount.merge(nums[right], 1, Integer::sum);
            意思是，如果 nums[right] 不存在，则为 1
            如果存在，则调用后面的函数，将新值 put 进去
             */
            while (numCount.getOrDefault(nums[right], 0) + 1 > k) {
                numCount.put(nums[left], numCount.get(nums[left]) - 1);
                left++;
            }
            numCount.put(nums[right], numCount.getOrDefault(nums[right], 0) + 1);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

}

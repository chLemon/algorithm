package endlesscheng;

public class No2302 {

    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        int left = 0;
        long sum = 0;   // 没必要存 score，不好调整，存个sum算也很快
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }

}

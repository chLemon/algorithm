package programmercarl;

public class No209 {

    public static void main(String[] args) {
        No209 no = new No209();
        no.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (start < nums.length || end <= nums.length) {
            if (sum < target) {
                if (end >= nums.length) break;
                sum += nums[end];
                end++;
            } else {
                min = Math.min(min, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;

//        int res = Integer.MAX_VALUE;
//        int left = 0;
//        int sum = 0;
//
//        for (int right = 0; right < nums.length; right++) {
//            sum += nums[right];
//
//            while (sum >= target) {
//                res = Math.min(res, right - left + 1);
//                sum -= nums[left++];
//            }
//        }
//        return res == Integer.MAX_VALUE ? 0 : res;
    }

}

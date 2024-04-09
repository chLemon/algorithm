package programmercarl;

import java.util.HashMap;
import java.util.Map;

class No1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num2Index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num2Index.containsKey(target - num)) {
                return new int[]{i, num2Index.get(target - num)};
            }
            num2Index.put(num, i);
        }
        return null;
    }

}

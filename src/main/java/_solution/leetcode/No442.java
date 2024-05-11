package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x < 0) continue;
            if (nums[x - 1] == x) {
                res.add(x);
                nums[i] *= -1;
            } else {
                int t = nums[x - 1];
                nums[x - 1] = x;
                nums[i--] = t;
            }
        }
        return res;
    }

}

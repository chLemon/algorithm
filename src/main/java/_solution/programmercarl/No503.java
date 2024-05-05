package _solution.programmercarl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class No503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int x = nums[i % n];
            while (!stack.isEmpty() && x > nums[stack.peek()]) {
                Integer last = stack.pop();
                res[last] = x;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return res;

    }

}

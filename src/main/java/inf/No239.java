package inf;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class No239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // in
            int x = nums[i];
            while (!deque.isEmpty() && x >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // out
            if (i - deque.peekFirst() + 1 > k) {
                deque.pollFirst();
            }
            // ans
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}

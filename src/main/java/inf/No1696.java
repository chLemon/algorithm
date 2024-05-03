package inf;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class No1696 {

    public static void main(String[] args) {
        new No1696().maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3);
    }

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];   // f可以优化掉，全部保存到单调队列里
        f[0] = nums[0];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);
        for (int i = 1; i < nums.length; i++) {
            // out
            // [i-k, i-1]
            if (deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            // i还未加入，所以一定 <= i-1
            f[i] = f[deque.peekFirst()] + nums[i];
            // in
            // 是f[i]的单调队列
            int x = f[i];
            while (!deque.isEmpty() && x >= f[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return f[n - 1];
    }

}

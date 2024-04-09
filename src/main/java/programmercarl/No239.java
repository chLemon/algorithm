package programmercarl;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class No239 {

    public static void main(String[] args) {
        No239 no = new No239();
        int[] ints = no.maxSlidingWindow(new int[]{1, -1}, 1);
        System.out.println(Arrays.toString(ints));
    }

    // 单调队列，只保留 最大值，及 最大值右侧比最大值小的数。相同的最大值需要保留多个
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        Deque<Integer> queue = new LinkedList<>();
        // 第一个窗口初始化
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.offer(nums[i]);
        }
        res[0] = queue.peekFirst();

        // 移动
        for (int i = 1; i < res.length; i++) {
            // nums[i-1]出窗口
            if (nums[i - 1] == queue.peek()) {
                queue.pollFirst();
            }
            // nums[i + k - 1]入窗口
            while (!queue.isEmpty() && queue.peekLast() < nums[i + k - 1]) {
                queue.pollLast();
            }
            queue.offer(nums[i + k - 1]);
            res[i] = queue.peekFirst();
        }
        return res;
    }

}

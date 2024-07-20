package _solution.leetcode;

import java.util.*;

class No239 {

    /*
    summary:
    困难
    hot100

    思路:
    单调队列
    重复元素是可以不保留在队列里的

    复杂度:
    时间 O(n)
    空间 O(min(k, U)) ，队列里可以不保留重复元素，U = nums 中不同元素的个数
     */

    public static void main(String[] args) {
        No239 no = new No239();
//        System.out.println(Arrays.toString(no.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(no.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }

    /*
    单调队列方法
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 用辅助队列，由于只关心最大值，所以队列内保留最大值右侧的小值，删除最大值的左侧的值
        // 辅助队列 单调非严格递减
        Deque<Integer> queue = new ArrayDeque<>();

        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            // 这里是可以省略的，仅通过在队尾删除就可以保证
//            while (!queue.isEmpty() && queue.peek() < nums[i]) {
//                queue.poll();
//            }
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.offer(nums[i]);
        }

        // 队列初始化完毕
        res[0] = queue.peek();

        // 窗口滑动
        for (int i = k; i < nums.length; i++) {
            // 左侧值出窗口
            if (queue.peek() == nums[i - k]) {
                queue.poll();
            }
            // 右侧的值进入窗口
            // 从队列头侧删除小于当前值的值
            // 这里是不是也可以省略？果然，只需要从小的方向去处理就可以
//            while (!queue.isEmpty() && queue.peek() < nums[i]) {
//                queue.poll();
//            }
            // 从队列尾删除小于当前值的值
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.offer(nums[i]);

            res[i - k + 1] = queue.peek();
        }

        return res;
    }

    /*
    使用大顶堆，会超时，因为remove是O(n)的
    复杂度：
    建堆：O(k)
    每次入堆:O(lnk)
    每次删除:O(k)
    总复杂度：O(k + n*k + n*lnk)
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        // 前k项入堆
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        res[0] = heap.peek();
        // i是右边界
        for (int i = k; i < nums.length; i++) {
            // 窗口滑动
            heap.remove(nums[i - k]);
            heap.add(nums[i]);
            res[i - k + 1] = heap.peek();
        }
        return res;
    }

}

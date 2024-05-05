package _solution.leetcode;

import java.util.*;

class No239 {

    /*
    给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

    返回 滑动窗口中的最大值 。
    
    示例 1：

    输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    输出：[3,3,5,5,6,7]
    解释：
    滑动窗口的位置                最大值
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
    示例 2：
    
    输入：nums = [1], k = 1
    输出：[1]
     
    
    提示：
    
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    1 <= k <= nums.length
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

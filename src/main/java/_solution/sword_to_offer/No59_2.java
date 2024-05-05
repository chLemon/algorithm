package _solution.sword_to_offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class No59_2 {
    /*
    请定义一个队列并实现函数 max_value 得到队列里的最大值，
    要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

    若队列为空，pop_front 和 max_value 需要返回 -1
     */
    class MaxQueue {

        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();

        public MaxQueue() {
        }

        public int max_value() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.offer(value);
        }

        public int pop_front() {
            Integer poll = queue.poll();
            if (!deque.isEmpty() && deque.peek().equals(poll)) {
                deque.poll();
            }
            return poll == null ? -1 : poll;
        }
    }

    public void test() {
        MaxQueue max = new MaxQueue();
        max.pop_front();
        max.pop_front();
        max.pop_front();
        max.pop_front();
        max.pop_front();
        max.push_back(15);
        max.max_value();
        max.push_back(9);
        max.max_value();
    }

}

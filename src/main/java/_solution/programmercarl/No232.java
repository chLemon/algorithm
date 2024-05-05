package _solution.programmercarl;

import java.util.ArrayDeque;
import java.util.Deque;

class No232 {

    class MyQueue {

        Deque<Integer> write = new ArrayDeque<>();
        Deque<Integer> read = new ArrayDeque<>();

        public MyQueue() {

        }

        public void push(int x) {
            write.push(x);
        }

        public int pop() {
            if (read.isEmpty()) {
                while (!write.isEmpty()) {
                    read.push(write.pop());
                }
            }
            return read.pop();
        }

        public int peek() {
            if (read.isEmpty()) {
                while (!write.isEmpty()) {
                    read.push(write.pop());
                }
            }
            return read.peek();
        }

        public boolean empty() {
            return write.isEmpty() && read.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

}

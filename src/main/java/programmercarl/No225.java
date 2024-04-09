package programmercarl;

import java.util.LinkedList;
import java.util.Queue;

class No225 {

    class MyStack {

        Queue<Integer> store = new LinkedList<>();
        Queue<Integer> emptyHelper = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            store.offer(x);
        }

        public int pop() {
            int lastPoll = store.poll();
            while (!store.isEmpty()) {
                emptyHelper.offer(lastPoll);
                lastPoll = store.poll();
            }
            Queue<Integer> tmp = store;
            store = emptyHelper;
            emptyHelper = tmp;
            return lastPoll;
        }

        public int top() {
            int pop = pop();
            store.offer(pop);
            return pop;
        }

        public boolean empty() {
            return store.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}

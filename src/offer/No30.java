package offer;

import java.util.Stack;

public class No30 {

    /*
    定义栈的数据结构，
    请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
    调用 min、push 及 pop 的时间复杂度都是 O(1)。
     */
    public static void main(String[] args) {

        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }

    static class MinStack {

        private Stack<Integer> stackMain = new Stack<>();
        private Stack<Integer> stackSupport = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {
//             stackMain = new Stack<>();
//             stackSupport = new Stack<>();
        }

        public void push(int x) {
            stackMain.push(x);

            if (stackSupport.isEmpty() || x <= stackSupport.peek()) {
                stackSupport.push(x);
            }
        }

        public void pop() {
            if (stackSupport.peek().equals(stackMain.peek())) {
                stackSupport.pop();
            }
            stackMain.pop();
        }

        public int top() {
            return stackMain.peek();
        }

        public int min() {
            return stackSupport.peek();
        }
    }

}

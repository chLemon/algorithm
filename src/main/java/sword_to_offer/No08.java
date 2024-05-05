package sword_to_offer;

import java.util.Stack;

class No08 {

    /*
    用两个栈实现一个队列。
    队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
    分别完成在队列尾部插入整数和在队列头部删除整数的功能。
    (若队列中没有元素，deleteHead 操作返回 -1 )

     */
    class CQueue {
        private Stack<Integer> support;
        private Stack<Integer> main;

        public CQueue() {
            support = new Stack<Integer>();
            main = new Stack<Integer>();
        }

        public void appendTail(int value) {
            //先把主栈所有的压入辅助栈
            while (!main.empty()) {
                support.push(main.pop());
            }
            //把新元素压入辅助栈
            support.push(value);
            //辅助栈所有元素放入主栈
            while (!support.empty()) {
                main.push(support.pop());
            }
        }

        public int deleteHead() {
            if (main.empty()){
                return -1;
            }
            return main.pop();
        }
    }
    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
}

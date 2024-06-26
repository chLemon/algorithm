package _solution.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class No225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        int top = myStack.top();
        System.out.println(top);
    }

}

/*

请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。

实现 MyStack 类：

void push(int x) 将元素 x 压入栈顶。
int pop() 移除并返回栈顶元素。
int top() 返回栈顶元素。
boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 

注意：

你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。

 */
class MyStack {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        if (q2.isEmpty()) {
            q1.offer(x);
        } else {
            q2.offer(x);
        }
    }

    public int pop() {
        Queue<Integer> hasValueQueue = q1.isEmpty() ? q2 : q1;
        Queue<Integer> emptyQueue = q1.isEmpty() ? q1 : q2;

        int times = hasValueQueue.size();
        for (int i = 0; i < times - 1; i++) {
            emptyQueue.offer(hasValueQueue.poll());
        }
        return hasValueQueue.poll();
    }

    public int top() {
        int pop = pop();
        push(pop);
        return pop;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
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
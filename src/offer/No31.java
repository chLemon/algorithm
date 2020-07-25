package offer;

import java.util.Stack;

public class No31 {
    /*
    输入两个整数序列，
    第一个序列表示栈的压入顺序，
    请判断第二个序列是否为该栈的弹出顺序。
    假设压入栈的所有数字均不相等。
    例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
    序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
    但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
//栈混洗
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;

        while (true) {
            if (j==popped.length){return true;}
            if (i<pushed.length && pushed[i] == popped[j]){
                j++;
                i++;
            }else if(!stack.isEmpty() && popped[j]==stack.peek()){
                stack.pop();
                j++;
            }else {
                if (i==pushed.length){return false;}
                stack.push(pushed[i]);
                i++;
            }
        }

    }

    public static void main(String[] args) {

        new No31().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }
}

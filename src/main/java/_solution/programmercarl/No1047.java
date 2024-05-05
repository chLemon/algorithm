package _solution.programmercarl;

import java.util.ArrayDeque;
import java.util.Deque;

class No1047 {

    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        char[] resArr = new char[stack.size()];
        for (int i = resArr.length - 1; i >= 0; i--) {
            resArr[i] = stack.pop();
        }
        return new String(resArr);
    }

}

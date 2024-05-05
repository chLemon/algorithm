package _solution.programmercarl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

class No150 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (new HashSet<>(Arrays.asList("+", "-", "*", "/")).contains(token)) {
                int c2 = stack.pop();
                int c1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(c1 + c2);
                        break;
                    case "-":
                        stack.push(c1 - c2);
                        break;
                    case "*":
                        stack.push(c1 * c2);
                        break;
                    case "/":
                        stack.push(c1 / c2);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(token));
            }

        }
        return stack.pop();
    }

}

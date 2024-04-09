package programmercarl;

import java.util.ArrayDeque;
import java.util.Deque;

class No20 {

    public boolean isValid(String s) {
        // 1. 左括号入栈，匹配对应的右括号出栈（唉，这个也挺好）；2. 相反括号入栈，匹配相同出栈
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    if (c != pop) return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

}

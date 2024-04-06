package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class No20 {

    public static void main(String[] args) {
        No20 no = new No20();
        System.out.println(no.isValid("()"));       // t 
        System.out.println(no.isValid("()[]{}"));   // t
        System.out.println(no.isValid("(]"));       // f
    }

    /*
    
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    
    有效字符串需满足：
    
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    每个右括号都有一个对应的相同类型的左括号。
     
    
    示例 1：
    
    输入：s = "()"
    输出：true
    示例 2：
    
    输入：s = "()[]{}"
    输出：true
    示例 3：
    
    输入：s = "(]"
    输出：false

     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }
}

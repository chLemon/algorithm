package _solution.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class No32 {

    public static void main(String[] args) {
        No32 no = new No32();
        no.longestValidParentheses(")()())");
    }

    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            } else {
                stack.push(i);
            }
            max = Math.max(max,
                    i - (stack.isEmpty() ? -1 : stack.peek())
            );
        }
        return max;
//        if (s.isEmpty()) return 0;
//        Deque<Character> bracketStack = new ArrayDeque<>();
//        Deque<Integer> indexStack = new ArrayDeque<>();
//        int maxLen = 0;
//
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == ')') {
//                if (!bracketStack.isEmpty() && bracketStack.peek() == '(') {
//                    bracketStack.pop();
//                    indexStack.pop();
//                    int last = indexStack.isEmpty() ? -1 : indexStack.peek();
//                    maxLen = Math.max(maxLen, i - last);
//                    continue;
//                }
//            }
//            bracketStack.push(chars[i]);
//            indexStack.push(i);
//        }
//        return maxLen;
    }

}

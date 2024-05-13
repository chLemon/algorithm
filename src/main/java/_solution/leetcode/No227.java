package _solution.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No227 {

    public static void main(String[] args) {
        System.out.println(new No227().calculate(" 1-1+1 "));
    }

    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> operations = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operations.push(c);
                continue;
            }
            int n = s.charAt(i) - '0';
            while (i + 1 < s.length()
                    && s.charAt(i + 1) >= '0'
                    && s.charAt(i + 1) <= '9') {
                n = n * 10 + s.charAt(i + 1) - '0';
                i++;
            }
            nums.push(n);

            while (!operations.isEmpty() && (operations.peek() == '*' || operations.peek() == '/')) {
                Integer n1 = nums.pop();
                Integer n2 = nums.pop();
                int res = operations.pop() == '*'
                        ? n1 * n2
                        : n1 / n2;
                nums.push(res);
            }
        }
        // 计算所有的加减；注意顺序和上面不一样
        while (!operations.isEmpty()) {
            Integer n1 = nums.pollLast();
            Integer n2 = nums.pollLast();
            int res = operations.pollLast() == '+'
                    ? n1 + n2
                    : n1 - n2;
            nums.offerLast(res);
        }
        return nums.pop();
    }

}

package _solution.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class No224 {

    Deque<Integer> nums = new ArrayDeque<>();
    Deque<Character> ops = new ArrayDeque<>();

    public static void main(String[] args) {
//        System.out.println(new No224().calculate("1 + 1"));
//        System.out.println(new No224().calculate(" 2-1 + 2 "));
//        System.out.println(new No224().calculate("(1+(4+5+2)-3)+(6+8)"));
//        System.out.println(new No224().calculate("1-(     -2)"));
        System.out.println(new No224().calculate("2-(5-6)"));
    }

    public int calculate(String s) {
        int n = s.length();

        // 计算时机的问题
        // 因为有括号，除了 ) 可以立刻计算外，所有的操作，必须等到下一个操作符出现，才知道是否可以计算
        char lastValid = '\0';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                // 数字
                int e = i;
                while (e < n && Character.isDigit(s.charAt(e))) e++;
                nums.push(Integer.parseInt(s.substring(i, e)));
                i = e - 1;
            } else {
                // 符号
                switch (c) {
                    case '(':
                        ops.push(c);
                        break;
                    case ')':
                        // 计算所有 (...)   这里的计算还需要论证
                        // +-*/  */+-
                        // 以下逻辑保证了，括号内未计算的，至多为 1个+/- 和 1个*// 
                        while (!ops.isEmpty() && ops.peek() != '(') cal();
                        ops.pop();
                        break;
                    case '*':
                    case '/':
                        // 如果之前有 * / ，则可以计算
                        while (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) cal();
                        ops.push(c);
                        break;
                    case '-':
                        if (lastValid == '\0' || lastValid == '(') nums.push(0);
                    case '+':
                        // 如果之前 有 * / + -，都可以计算
                        while (!ops.isEmpty() &&
                                (ops.peek() == '*' || ops.peek() == '/' || ops.peek() == '+' || ops.peek() == '-'))
                            cal();
                        ops.push(c);
                        break;
                }
            }
            lastValid = c;
        }
        // 遍历完s后，ops可能不为空
        while (!ops.isEmpty()) {
            cal();
        }
        return nums.pop();
    }

    private void cal() {
        char op = ops.pop();
        int n2 = nums.pop();
        int n1 = nums.pop();
        int res = 0;
        switch (op) {
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n1 - n2;
                break;
            case '*':
                res = n1 * n2;
                break;
            case '/':
                res = n1 / n2;
                break;
        }
        nums.push(res);
    }

}

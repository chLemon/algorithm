package _solution.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class No901 {

    class StockSpanner {

        Deque<Integer> stack = new ArrayDeque<>();
        // 可以不用这个list  在 stack里保存index+price信息
        List<Integer> prices = new ArrayList<>();

        public StockSpanner() {
        }

        public int next(int price) {
            int i = prices.size();
            prices.add(price);
            while (!stack.isEmpty() && price >= prices.get(stack.peek())) {
                stack.pop();
            }
            int last = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
            return i - last;
        }
    }

}

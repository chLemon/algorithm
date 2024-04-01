package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No84 {

    public static void main(String[] args) {
        No84 no = new No84();
        int i = no.largestRectangleArea(new int[]{1, 6, 6, 1});
        System.out.println(i);
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && cur < heights[stack.peek()]) {
                int pop = stack.pop();
                int h = heights[pop];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int w = i - left - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }

}

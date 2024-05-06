package _solution.programmercarl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class No84 {

    public static void main(String[] args) {
        new No84().largestRectangleArea(new int[]{2, 1, 2});
    }

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] tmp = new int[n];
        Arrays.fill(tmp, -1);
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                Integer pop = stack.pop();
                tmp[pop] = i;
            }
            stack.push(i);
        }

        for (int i = 0; i <= heights.length; i++) {
            int x = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty()) {
                if (!(x < heights[stack.peek()])) break;
                Integer last = stack.pop();
                int w = i - tmp[last] - 1;
                max = Math.max(max, heights[last] * w);
            }
            stack.push(i);
        }
        return max;
    }

}

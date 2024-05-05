package _solution.programmercarl;

import java.util.ArrayDeque;
import java.util.Deque;

class No739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer last = stack.pop();
                res[last] = i - last;
            }
            stack.push(i);
        }
        return res;
    }

}

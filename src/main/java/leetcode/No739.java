package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class No739 {

    public static void main(String[] args) {
        No739 no = new No739();
        int[] ints = no.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    Integer pop = stack.pop();
                    res[pop] = i - pop;
                }
            }
            stack.push(i);
        }
        return res;
    }

}

package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No42 {

    public static void main(String[] args) {
        No42 no = new No42();
        int trap = no.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }

    // 单调栈
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            // 这里大于和大于等于都可以
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = height[stack.pop()];
                if (stack.isEmpty()) {
                    break; // 类似于第二根大于第一根 
                }
                int leftIndex = stack.peek();
                int dh = Math.min(height[leftIndex], height[i]) - bottom;
                res += dh * (i - leftIndex - 1);
            }
            stack.push(i);
        }
        return res;
    }

    // 面积法
    public int trap4(int[] height) {
        int n = height.length;
        int sum = 0;
        int max = 0;
        for (int h : height) {
            sum += h;
            max = Math.max(max, h);
        }
        int full = max * n;

        int lSum = 0;
        int lMax = 0;
        for (int h : height) {
            lMax = Math.max(h, lMax);
            lSum += lMax;
        }

        int rSum = 0;
        int rMax = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rMax = Math.max(height[i], rMax);
            rSum += rMax;
        }

        return lSum + rSum - full - sum;
    }

    // 左右两个指针，左指针维护左侧出现的最大高度，右指针维护右侧出现的最大高度
    // 假设当前情况下，左指针值为1，右指针值为3
    // 那么对于左指针所在位置，左边最高是1，右边最高值最少是3，其最大容纳水量就是 1 - height[left]
    // 那么对于右边同理。即 最大值小的那个的数会被确定
    public int trap3(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    // 双指针
    public int trap2(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        // 0-i中，最高的高度
        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];
        leftHeight[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftHeight[i] = Math.max(height[i], leftHeight[i - 1]);
        }
        rightHeight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightHeight[i] = Math.max(height[i], rightHeight[i + 1]);
        }

        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            sum += Math.min(leftHeight[i], rightHeight[i]) - height[i];
        }
        return sum;
    }

}

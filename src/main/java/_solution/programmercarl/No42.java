package _solution.programmercarl;

class No42 {

    public int trap(int[] height) {
        int n = height.length;
        int leftMax = -1;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }

        int rightMax = -1;
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            right[i] = rightMax;
            rightMax = Math.max(rightMax, height[i]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(0,
                    Math.min(left[i], right[i]) - height[i]);
        }
        return sum;
    }

}

package _solution.inf;

class No42 {

    public int trap(int[] height) {
        int count = 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                count += leftMax - height[left];
                left++;
            } else {
                count += rightMax - height[right];
                right--;
            }
        }
        return count;
    }

}

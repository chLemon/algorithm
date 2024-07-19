package _solution.leetcode;

class No11 {

    /*
    summary:
    中等
    hot100

    思路:
    从最外侧的两个柱子开始考察。
    如果答案不是由当前2个柱子围起来的面积，较短的一根柱子一定不会在答案里，排除掉进行收缩

    复杂度:
    时间 O(n)
    空间 O(1)
     */

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}

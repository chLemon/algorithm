# https://leetcode.cn/problems/container-with-most-water/description/
# O(n) O(1)
# 相向双指针


class Solution:
    def maxArea(self, height: List[int]) -> int:
        # 考察 i , j 的两个柱子，假如当前不是答案，那较矮的那根，无论如何都不会成为更大解的其中之一，所以可以直接略过
        left, right = 0, len(height) - 1
        max_area = 0
        while left < right:
            area = (right - left) * min(height[left], height[right])
            max_area = max(max_area, area)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return max_area

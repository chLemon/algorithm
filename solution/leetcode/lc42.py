# https://leetcode.cn/problems/trapping-rain-water/description/
# O(n) O(1)
# 相向双指针

class Solution:
    def trap1(self, height: List[int]) -> int:
        # 每一块位置能接到的雨水，可以看作是两块木板挡下的，左侧木板是左侧最高的值，这个值可以算上当前值，右侧同理
        n = len(height)
        # 定义 i 处，左侧 0 到 i 最高的为 left_max[i]
        left_max = [0] * n
        left_max[0] = height[0]
        right_max = [0] * n
        right_max[-1] = height[-1]

        for i in range(1, n):
            left_max[i] = max(left_max[i - 1], height[i])

        for i in range(n - 2, -1, -1):
            right_max[i] = max(right_max[i + 1], height[i])

        count = 0
        for h, pre, suf in zip(height, left_max, right_max):
            count += min(pre, suf) - h
        return count

    def trap2(self, height: List[int]) -> int:
        # 双指针，在某个时刻，可以确定的是，双指针之间可能有更高的墙，但是两边最终的墙的高度却不会再变矮了。所以短的那个边的值其实就已经确定了。
        n = len(height)
        count = left = l_height = r_height = 0
        right = n - 1
        while left <= right:
            if l_height < r_height:
                count += max(0, l_height - height[left])
                l_height = max(l_height, height[left])
                left += 1
            else:
                count += max(0, r_height - height[right])
                r_height = max(r_height, height[right])
                right -= 1
        return count

    def trap(self, height: List[int]) -> int:
        return self.trap2(height)

# 题目链接: https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
# 时空复杂度: O(n) O(1)
# Tags: 同向双指针，正难则反
from typing import List


class Solution:
    def sol1(self, nums: List[int], x: int) -> int:
        # 逆向这个思路简直是天才
        # 先求最长的，可以让子数组和为 sum(nums) - x 的长度
        y = sum(nums) - x
        if y < 0:
            return -1

        left = s = 0
        max_len = -1
        for right, x in enumerate(nums):
            s += nums[right]
            while s > y:
                s -= nums[left]
                left += 1
            if s == y:
                max_len = max(max_len, right - left + 1)
        return -1 if max_len < 0 else len(nums) - max_len

    def sol2(self, nums: List[int], x: int) -> int:
        # 按照题目描述来
        # 同向双指针的精髓在于，考察以某个元素为边界的数组，另一个边界可以单项收缩，收缩到不可能存在答案的情况下，纳入一个新元素，继续考察新元素为边界的情况
        # 通常一步一步移动的都是某个右边界
        # 所以在每轮循环结束，即将纳入新元素的时候，数组都是一定不会再有新答案潜藏其中了
        # 那么现在就是找到一个右边的数组，其中的 sum <= x，然后这个其实是作为答案的左边界，左边的数组其实是答案的右边界
        right = n = len(nums)
        s = 0
        while right and s + nums[right - 1] <= x:
            right -= 1
            s += nums[right]
        if right == 0 and s < x:
            # 所有的数字都加起来了 也不行
            return -1

        # 否则 right 应该在让 [right, n) <= x 的位置
        # right 还可能在 n 的位置
        ans = n - right if s == x else n + 1

        # 该处理左侧的数组了
        for left, num in enumerate(nums):
            s += num
            while s > x and right < n:
                s -= nums[right]
                right += 1
            if s > x:
                break  # 已经无法继续缩小了，前缀很大了
            if s == x:
                ans = min(ans, left + 1 + n - right)
        return ans if ans <= n else -1

    def minOperations(self, nums: List[int], x: int) -> int:
        return self.sol2(nums, x)

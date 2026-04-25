# 题目链接: https://leetcode.cn/problems/target-sum/
# 时空复杂度:
# Tags: 0-1背包

from functools import cache
from typing import List


class Solution:

    def mem_search(self, nums: List[int], target: int) -> int:
        # 所有数都是正数，等价转换为，从里面挑出来一些数，和为目标值
        # 选取出的和是 x，剩余的和是 sum - x
        # x - (sum - x) = target => 2x = target + sum => x = (target + sum) / 2
        # 所以 target + sum 必须是偶数
        s = sum(nums) + target
        if s % 2 or s < 0:
            return 0

        @cache
        def dfs(i: int, c: int) -> int:
            if i < 0:
                return 1 if c == 0 else 0
            if c < 0:
                return 0
            return dfs(i - 1, c - nums[i]) + dfs(i - 1, c)

        x = s // 2
        return dfs(len(nums) - 1, x)

    def f_func_1(self, nums: List[int], target: int) -> int:
        s = sum(nums) + target
        if s % 2 or s < 0:
            return 0
        m = s // 2
        n = len(nums)

        f = [[0] * (m + 1) for _ in range(n + 1)]
        f[0][0] = 1

        for i, x in enumerate(nums):
            for c in range(m + 1):
                if c < nums[i]:
                    f[i + 1][c] = f[i][c]
                else:
                    f[i + 1][c] = f[i][c] + f[i][c - x]
        return f[n][m]

    def f_func_2(self, nums: List[int], target: int) -> int:
        s = sum(nums) + target
        if s % 2 or s < 0:
            return 0

        m = s // 2
        f = [1] + [0] * m
        for x in nums:
            for c in range(m, x - 1, -1):
                f[c] += f[c - x]
        return f[m]

    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        return self.f_func_2(nums, target)

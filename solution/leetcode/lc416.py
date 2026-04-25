# 题目链接: https://leetcode.cn/problems/partition-equal-subset-sum/description/
# 时空复杂度:
# Tags:


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        target = sum(nums)
        if target % 2:
            return False
        target //= 2

        # @cache
        # def dfs(i: int, c: int) -> bool:
        #     if i < 0:
        #         return True if c == 0 else False
        #     if c < nums[i]:
        #         return dfs(i - 1, c)
        #     return dfs(i - 1, c) or dfs(i - 1, c - nums[i])

        f = [True] + [False] * (target)
        for x in nums:
            for j in range(target, x - 1, -1):
                f[j] = f[j] or f[j - x]

        # return dfs(len(nums) - 1, target)
        return f[-1]

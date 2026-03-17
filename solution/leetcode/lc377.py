# 题目链接: https://leetcode.cn/problems/combination-sum-iv/description/
# 时空复杂度: O(n) O(n)
# Tags:

from functools import cache

class Solution:

    def mem_search(self, nums: List[int], target: int) -> int:
        @cache
        def dfs(i, left):
            if left < 0:
                return 0
            if left == 0:
                return 1
            ans = 0
            for j in range(i, len(nums)):
                ans += dfs(i, left - nums[j])
            return ans

        return dfs(0, target)


    def mem_search_opt(self, nums: List[int], target: int) -> int:
        @cache
        def dfs(left):
            if left < 0:
                return 0
            if left == 0:
                return 1
            ans = 0
            for j in range(len(nums)):
                ans += dfs(left - nums[j])
            return ans

        return dfs(target)

    # 本质上是爬楼梯
    # nums 里的数是可以爬的台阶数，爬到 target 有多少种方案
    # 如果最后爬了 nums[j]，那么问题就变为爬 i - nums[j] 个台阶的方案
    # f[j] = sum(f[i - nums[j]])
    def combinationSum4(self, nums: List[int], target: int) -> int:
        f = [1] + [0] * target
        for i in range(1, target + 1):
            f[i] = sum(f[i - x] for x in nums if x <= i)
        return f[target]


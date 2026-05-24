# 题目链接: https://leetcode.cn/problems/longest-increasing-subsequence/
# 时空复杂度:
# Tags:


from bisect import bisect_left

class Solution:

    def mem_search(self, nums: List[int]) -> int:
        @cache
        def dfs(i) -> int:
            m = 0
            for j in range(i):
                if nums[j] < nums[i]:
                    m = max(m, dfs(j))
            return m + 1

        return max(dfs(i) for i in range(len(nums)))

    def f(self, nums: List[int]) -> int:
        n = len(nums)
        f = [0] * (n)
        for i, x in enumerate(nums):
            m = 0
            for j, y in enumerate(nums[:i]):
                if y < x:
                    m = max(m, f[j])
            f[i] = m + 1
        return max(f)

    def g(self, nums: List[int]) -> int:
        g = []
        for x in nums:
            i = bisect_left(g, x)
            if i == len(g):
                g.append(x)
            else:
                g[i] = x
        return len(g)

    def lengthOfLIS(self, nums: List[int]) -> int:
        return self.g(nums=nums)

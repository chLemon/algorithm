# 题目链接: https://leetcode.cn/problems/length-of-the-longest-subsequence-that-sums-to-target/description/
# 时空复杂度:
# Tags:


class Solution:

    def mem_search(self, nums: List[int], target: int) -> int:

        @cache
        def dfs(i, c):
            if c < 0:
                return -inf
            if i < 0:
                return 0 if c == 0 else -inf
            return max(dfs(i - 1, c), dfs(i - 1, c - nums[i]) + 1)

        ans = dfs(len(nums) - 1, target)
        dfs.cache_clear()  # 防止爆内存
        return ans if ans > 0 else -1

    def bag(self, nums: List[int], target: int) -> int:
        f = [0] + [-inf] * target
        for x in nums:
            for c in range(target, x - 1, -1):
                f[c] = max(f[c], f[c - x] + 1)
        ans = f[target]
        return ans if ans > 0 else -1

    def lengthOfLongestSubsequence(self, nums: List[int], target: int) -> int:
        return self.bag(nums, target)

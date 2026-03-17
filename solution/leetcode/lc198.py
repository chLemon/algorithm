# 题目链接: https://leetcode.cn/problems/house-robber/description/
# 时空复杂度: O(n) O(1)
# Tags: DP

class Solution:
    def rob(self, nums: List[int]) -> int:
        f0 = f1 = 0
        for x in nums:
            f0, f1 = f1, max(f1, f0 + x)
        return f1
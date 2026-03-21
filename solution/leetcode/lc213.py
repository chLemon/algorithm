# 题目链接: https://leetcode.cn/problems/house-robber-ii/description/
# 时空复杂度:
# Tags:


class Solution:
    # 也可以直接复用简单版本，分类讨论后，增加数组边界即可
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        # f 选第一个 g 不选第一个
        f0, f1, g0, g1 = 0, nums[0], 0, 0
        for i in range(1, n - 1):
            f0, f1 = f1, max(f1, f0 + nums[i])
            g0, g1 = g1, max(g1, g0 + nums[i])
        # 最后一个，g 可以选，f 不能
        g1 = max(g1, g0 + nums[n - 1])
        return max(f1, g1)

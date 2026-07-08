# 题目链接: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
# 时空复杂度:
# Tags:

from math import inf


class Solution:

    def f_opt_v(self, prices: List[int]) -> int:
        f0, f_pre, f1 = 0, 0, -inf

        for p in prices:
            f1, f0, f_pre = max(f1, f_pre - p), max(f0, f1 + p), f0
        return f0

    def f_v(self, prices: List[int]) -> int:
        n = len(prices)
        f = [[0] * 2 for _ in range(n + 2)]
        f[0][1] = f[1][1] = -inf

        for i, p in enumerate(prices):
            f[i + 2][1] = max(f[i + 1][1], f[i][0] - p)
            f[i + 2][0] = max(f[i + 1][0], f[i + 1][1] + p)
        return f[-1][0]

    def dfs_v(self, prices: List[int]) -> int:

        @cache
        def dfs(i: int, hold: bool) -> int:
            if i < 0:
                return -inf if hold else 0
            if hold:
                return max(dfs(i - 1, True), dfs(i - 2, False) - prices[i])
            return max(dfs(i - 1, False), dfs(i - 1, True) + prices[i])

        return dfs(len(prices) - 1, False)

    def maxProfit(self, prices: List[int]) -> int:
        return self.f_opt_v(prices)

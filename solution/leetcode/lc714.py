# 题目链接: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
# 时空复杂度:
# Tags:


class Solution:

    def f_opt_v(self, prices: List[int], fee: int) -> int:
        f0, f1 = 0, -inf
        for p in prices:
            f1, f0 = max(f1, f0 - p), max(f0, f1 + p - fee)
        return f0

    def f_v(self, prices: List[int], fee: int) -> int:
        n = len(prices)
        f = [[0] * 2 for _ in range(n + 1)]
        f[0][1] = -inf

        for i, p in enumerate(prices):
            f[i + 1][1] = max(f[i][1], f[i][0] - p)
            f[i + 1][0] = max(f[i][0], f[i][1] + p - fee)
        return f[-1][0]

    def dfs_v(self, prices: List[int], fee: int) -> int:
        @cache
        def dfs(i: int, hold: bool):
            if i < 0:
                return -inf if hold else 0
            if hold:
                return max(dfs(i - 1, True), dfs(i - 1, False) - prices[i])
            return max(dfs(i - 1, False), dfs(i - 1, True) + prices[i] - fee)

        return dfs(len(prices) - 1, False)

    def maxProfit(self, prices: List[int], fee: int) -> int:
        return self.f_opt_v(prices, fee)

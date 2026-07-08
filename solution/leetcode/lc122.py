# 题目链接: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
# 时空复杂度:
# Tags:

from math import inf


class Solution:
    """
    状态机：

    持有 --> 持有 dfs(i + 1, 1) = dfs(i, 1)
    买：未持有 --> 持有 dfs(i + 1, 1) = dfs(i, 0) - p[i]
    未持有 --> 未持有 dfs(i + 1, 0) = dfs(i, 0)
    卖：持有 --> 未持有 dfs(i + 1, 1) = dfs(i, 0) + p[i]
    """

    def dfs_v(self, prices: List[int]) -> int:

        @cache
        def dfs(i: int, hold: bool) -> int:
            if i < 0:
                return -inf if hold else 0
            if hold:
                return max(dfs(i - 1, True), dfs(i - 1, False) - prices[i])
            else:
                return max(dfs(i - 1, False), dfs(i - 1, True) + prices[i])

        return dfs(len(prices) - 1, False)

    def f_v(self, prices: List[int]) -> int:
        n = len(prices)
        d = [[0] * 2 for _ in range(n + 1)]
        d[0][1] = -inf

        for i in range(n):
            d[i + 1][0] = max(d[i][0], d[i][1] + prices[i])
            d[i + 1][1] = max(d[i][1], d[i][0] - prices[i])
        return d[n][0]

    def maxProfit(self, prices: List[int]) -> int:
        return self.dfs_v(prices)

# 题目链接: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/
# 时空复杂度:
# Tags:


class Solution:

    def f_opt_v(self, k: int, prices: List[int]) -> int:
        f = [[-inf] * 2 for _ in range(k + 2)]

        for j in range(1, k + 2):
            f[j][0] = 0

        for p in prices:
            for j in range(k + 1):
                f[j + 1][1], f[j + 1][0] = max(f[j + 1][1], f[j + 1][0] - p), max(
                    f[j + 1][0], f[j][1] + p
                )
        return f[-1][0]

    def f_v(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        # f[i][k][0/1]
        # k < 0 的部分全都是 -inf，i > 0 且 k >= 0 的部分会动态覆盖，直接初始化为 -inf
        f = [[[-inf] * 2 for _ in range(k + 2)] for _ in range(n + 1)]
        # 需要把 非 hold 的部分初始化为 0
        for j in range(1, k + 2):
            f[0][j][0] = 0

        for i, p in enumerate(prices):
            for j in range(k + 1):
                f[i + 1][j + 1][1] = max(f[i][j + 1][1], f[i][j + 1][0] - p)
                f[i + 1][j + 1][0] = max(f[i][j + 1][0], f[i][j][1] + p)

        return f[-1][-1][0]

    def dfs_v(self, k: int, prices: List[int]) -> int:
        @cache
        def dfs(i: int, hold: bool, k: int) -> int:
            if k < 0:
                return -inf
            if i < 0:
                return -inf if hold else 0
            if hold:
                return max(dfs(i - 1, True, k), dfs(i - 1, False, k) - prices[i])
            return max(dfs(i - 1, False, k), dfs(i - 1, True, k - 1) + prices[i])

        return dfs(len(prices) - 1, False, k)

    def maxProfit(self, k: int, prices: List[int]) -> int:
        return self.f_opt_v(k, prices)

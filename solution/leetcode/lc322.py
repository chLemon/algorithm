# 题目链接: https://leetcode.cn/problems/coin-change/description/
# 时空复杂度:
# Tags:

from functools import cache
from math import inf
from typing import List


class Solution:
    def mem_search(self, coins: List[int], amount: int) -> int:
        n = len(coins)

        @cache
        def dfs(i: int, left: int) -> int:
            if left < 0: return inf
            if i < 0:
                return 0 if left == 0 else inf
            return min(dfs(i - 1, left), dfs(i, left - coins[i]) + 1)

        res = dfs(n - 1, amount)
        return res if res < inf else -1

    def bag(self, coins: List[int], amount: int) -> int:
        f = [0] + [inf] * amount
        for x in coins:
            for c in range(x, amount + 1):
                f[c] = min(f[c], f[c - x] + 1)
        return f[amount] if f[amount] < inf else -1

    def coinChange(self, coins: List[int], amount: int) -> int:
        return self.bag(coins, amount)

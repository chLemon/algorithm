# 题目链接: https://leetcode.cn/problems/coin-change-ii/description/
# 时空复杂度:
# Tags:

class Solution:

    def mem_search(self, amount: int, coins: List[int]) -> int:
        @cache
        def dfs(i, c) -> int:
            if i < 0:
                return 1 if c == 0 else 0
            if c < coins[i]:
                return dfs(i - 1, c)
            return dfs(i - 1, c) + dfs(i, c - coins[i])

        return dfs(len(coins) - 1, amount)


    def change(self, amount: int, coins: List[int]) -> int:

        f = [1] + [0] * amount

        for x in coins:
            for j in range(x, amount + 1):
                f[j] = f[j] + f[j - x]
        return f[-1]

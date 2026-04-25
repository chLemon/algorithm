# 题目链接: https://leetcode.cn/problems/perfect-squares/description/
# 时空复杂度:
# Tags:

from math import isqrt


# @cache
# def dfs(i, c):
#     if i == 0:
#         return 0 if c == 0 else inf

#     if c < i * i:
#         return dfs(i - 1, c)
#     return min(dfs(i - 1, c), dfs(i, c - i * i) + 1)

N = 10**4
f = [0] + [inf] * N
for i in range(1, isqrt(N) + 1):
    for j in range(i * i, N + 1):
        f[j] = min(f[j], f[j - i * i] + 1)


class Solution:
    def numSquares(self, n: int) -> int:
        return f[n]

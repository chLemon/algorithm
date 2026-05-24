# 题目链接: https://leetcode.cn/problems/interleaving-string/
# 时空复杂度:
# Tags:
from functools import cache


class Solution:
    def f_opt(self, s1: str, s2: str, s3: str) -> bool:
        m, n = len(s1), len(s2)
        if m + n != len(s3):
            return False
        f = [False] * (n + 1)
        f[0] = True

        for j, y in enumerate(s2):
            f[j + 1] = y == s3[j] and f[j]

        for i, x in enumerate(s1):
            f[0] = f[0] and (x == s3[i])
            for j, y in enumerate(s2):
                f[j + 1] = (x == s3[i + j + 1] and f[j + 1]) or (
                    y == s3[i + j + 1] and f[j]
                )
        return f[-1]

    def f(self, s1: str, s2: str, s3: str) -> bool:
        m, n = len(s1), len(s2)
        if m + n != len(s3):
            return False

        f = [[False] * (n + 1) for _ in range(m + 1)]
        f[0][0] = True
        for i, x in enumerate(s1):
            f[i + 1][0] = x == s3[i] and f[i][0]
        for j, y in enumerate(s2):
            f[0][j + 1] = y == s3[j] and f[0][j]

        for i, x in enumerate(s1):
            for j, y in enumerate(s2):
                f[i + 1][j + 1] = (x == s3[i + j + 1] and f[i][j + 1]) or (
                    y == s3[i + j + 1] and f[i + 1][j]
                )
        return f[-1][-1]

    def mem_search2(self, s1: str, s2: str, s3: str) -> bool:
        m, n = len(s1), len(s2)
        if m + n != len(s3):
            return False

        @cache
        def dfs(i, j) -> bool:
            if i < 0 and j < 0:
                return True
            return (i >= 0 and s1[i] == s3[i + j + 1] and dfs(i - 1, j)) or (
                j >= 0 and s2[j] == s3[i + j + 1] and dfs(i, j - 1)
            )

        return dfs(m - 1, n - 1)

    def mem_search(self, s1: str, s2: str, s3: str) -> bool:

        @cache
        def dfs(i, j, k) -> bool:
            # if i + j + 1 != k:
            # return False
            if i < 0:
                return s2[: j + 1] == s3[: k + 1]
            if j < 0:
                return s1[: i + 1] == s3[: k + 1]
            if s1[i] == s3[k] and s2[j] == s3[k]:
                return dfs(i - 1, j, k - 1) or dfs(i, j - 1, k - 1)
            elif s1[i] == s3[k]:
                return dfs(i - 1, j, k - 1)
            elif s2[j] == s3[k]:
                return dfs(i, j - 1, k - 1)
            return False

        return dfs(len(s1) - 1, len(s2) - 1, len(s3) - 1)

    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        return self.f_opt(s1=s1, s2=s2, s3=s3)

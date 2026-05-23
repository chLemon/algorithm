# 题目链接: https://leetcode.cn/problems/longest-common-subsequence/description/
# 时空复杂度: O(mn)
# Tags:

from functools import cache


class Solution:

    def mem_search(self, text1: str, text2: str) -> int:

        @cache
        def dfs(i, j) -> int:
            if i < 0 or j < 0:
                return 0
            if text1[i] == text2[j]:
                return dfs(i - 1, j - 1) + 1
            return max(dfs(i - 1, j), dfs(i, j - 1))

        return dfs(len(text1) - 1, len(text2) - 1)

    # f[i][j] = f[i-1][j-1] if s ==  t else max(f[i-1][j], f[i][j-1])
    def f(self, text1: str, text2: str) -> int:
        n, m = len(text1), len(text2)
        f = [[0] * (m + 1) for _ in range(n + 1)]
        for i, x in enumerate(text1):
            for j, y in enumerate(text2):
                f[i + 1][j + 1] = (
                    f[i][j] + 1 if x == y else max(f[i][j + 1], f[i + 1][j])
                )
        return f[n][m]

    # f[i + 1][j + 1] = f[i][j] if s == t else max(f[i][j+1], f[i+1][j])
    def f_opt1(self, text1: str, text2: str) -> int:
        # 两个数组
        n, m = len(text1), len(text2)
        f = [[0] * (m + 1) for _ in range(2)]
        for i, x in enumerate(text1):
            for j, y in enumerate(text2):
                f[(i + 1) % 2][j + 1] = (
                    f[i % 2][j] + 1
                    if x == y
                    else max(f[i % 2][j + 1], f[(i + 1) % 2][j])
                )
        return f[n % 2][m]

    # f[i + 1][j + 1] = f[i][j] if s == t else max(f[i][j+1], f[i+1][j])
    def f_opt2(self, text1: str, text2: str) -> int:
        # 单个数组
        m = len(text2)
        f = [0] * (m + 1)
        for x in text1:
            pre = 0
            for j, y in enumerate(text2):
                tmp = f[j + 1]
                f[j + 1] = pre + 1 if x == y else max(f[j + 1], f[j])
                pre = tmp
        return f[m]

    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        return self.f_opt2(text1=text1, text2=text2)

# 题目链接: https://leetcode.cn/problems/longest-palindromic-subsequence/description/
# 时空复杂度:
# Tags:


class Solution:

    def f_v(self, s: str) -> int:
        n = len(s)
        f = [[0] * (n) for _ in range(n)]
        for i in range(n):
            f[i][i] = 1

        for i in range(n - 1, -1, -1):
            for j in range(n):
                if i >= j:
                    continue
                if s[i] == s[j]:
                    f[i][j] = f[i + 1][j - 1] + 2
                else:
                    f[i][j] = max(f[i + 1][j], f[i][j - 1])
        return f[0][-1]

    def dfs_v(self, s: str) -> int:
        # 左右两个指针，如果相同，那么就可以属于最长回文子序列里，否则应该只有一个可能是答案
        @cache
        def dfs(i, j):
            if i > j:
                return 0
            if i == j:
                return 1
            if s[i] == s[j]:
                return dfs(i + 1, j - 1) + 2
            return max(dfs(i + 1, j), dfs(i, j - 1))

        return dfs(0, len(s) - 1)

    def longestPalindromeSubseq(self, s: str) -> int:
        return self.f_v(s)

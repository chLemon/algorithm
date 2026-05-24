# 题目链接: https://leetcode.cn/problems/shortest-common-supersequence/description/
# 时空复杂度:
# Tags:

from functools import cache


class Solution:

    def mem_search(self, str1: str, str2: str) -> str:

        @cache
        def dfs(i, j) -> str:
            if i < 0:
                return str2[: j + 1]
            if j < 0:
                return str1[: i + 1]

            if str1[i] == str2[j]:
                return dfs(i - 1, j - 1) + str1[i]
            else:
                s1 = dfs(i - 1, j) + str1[i]
                s2 = dfs(i, j - 1) + str2[j]
                if len(s1) < len(s2):
                    return s1
                else:
                    return s2

        dfs.cache_clear()

        return dfs(len(str1) - 1, len(str2) - 1)

    def mem_search_opt(self, str1: str, str2: str) -> str:
        n, m = len(str1), len(str2)

        @cache
        def dfs(i, j) -> int:
            if i < 0:
                return j + 1
            if j < 0:
                return i + 1

            if str1[i] == str2[j]:
                return dfs(i - 1, j - 1) + 1
            else:
                return min(dfs(i - 1, j), dfs(i, j - 1)) + 1

        dfs(n - 1, m - 1)

        def make_ans(i, j) -> str:
            if i < 0:
                return str2[: j + 1]
            if j < 0:
                return str1[: i + 1]

            if str1[i] == str2[j]:
                return make_ans(i - 1, j - 1) + str1[i]
            else:
                # 这里可以合并为  if dfs(i, j) == dfs(i - 1, j) + 1:
                if dfs(i - 1, j) < dfs(i, j - 1):
                    return make_ans(i - 1, j) + str1[i]
                else:
                    return make_ans(i, j - 1) + str2[j]

        return make_ans(n - 1, m - 1)

    def f(self, str1: str, str2: str) -> str:
        n, m = len(str1), len(str2)
        f = [[0] * (m + 1) for _ in range(n + 1)]
        f[0] = list(range(m + 1))

        for i in range(1, n + 1):
            f[i][0] = i
            # 递归边界，这个一定要在这里，下面计算 f[i + 1][j + 1] 的值依赖 f[i + 1][0]，下面写容易写成 f[i][0] 的初始化

        for i, x in enumerate(str1):
            for j, y in enumerate(str2):
                if x == y:
                    f[i + 1][j + 1] = f[i][j] + 1
                else:
                    f[i + 1][j + 1] = min(f[i + 1][j], f[i][j + 1]) + 1

        # 这里不能正着搞，正着找不到正确的路
        ans = []
        i, j = n - 1, m - 1
        while i >= 0 and j >= 0:
            if str1[i] == str2[j]:
                ans.append(str1[i])
                i -= 1
                j -= 1
            else:
                if f[i][j + 1] < f[i + 1][j]:
                    ans.append(str1[i])
                    i -= 1
                else:
                    ans.append(str2[j])
                    j -= 1
        return str1[: i + 1] + str2[: j + 1] + "".join(ans[::-1])

    def correct(self, s: str, t: str) -> str:
        n, m = len(s), len(t)
        # f[i+1][j+1] 表示 s 的前缀 [0,i] 和 t 的前缀 [0,j] 的最短公共超序列的长度
        f = [[0] * (m + 1) for _ in range(n + 1)]
        f[0] = list(range(m + 1))  # 递归边界 f[0][j] = j
        for i in range(1, n + 1):
            f[i][0] = i  # 递归边界
        for i, x in enumerate(s):
            for j, y in enumerate(t):
                if x == y:  # 最短公共超序列一定包含 s[i]
                    f[i + 1][j + 1] = f[i][j] + 1
                else:  # 取更短的组成答案
                    f[i + 1][j + 1] = min(f[i][j + 1], f[i + 1][j]) + 1

        ans = []
        i, j = n - 1, m - 1
        while i >= 0 and j >= 0:
            if s[i] == t[j]:  # 公共超序列一定包含 s[i]
                ans.append(s[i])
                i -= 1
                j -= 1  # 相当于继续递归 make_ans(i - 1, j - 1)
            elif f[i + 1][j + 1] == f[i][j + 1] + 1:
                ans.append(s[i])
                i -= 1  # 相当于继续递归 make_ans(i - 1, j)
            else:
                ans.append(t[j])
                j -= 1  # 相当于继续递归 make_ans(i, j - 1)

        # 补上前面的递归边界
        # reversed(ans) 也可以写成 ans[::-1]
        return s[: i + 1] + t[: j + 1] + "".join(reversed(ans))

    def shortestCommonSupersequence(self, str1: str, str2: str) -> str:
        return self.f(str1=str1, str2=str2)

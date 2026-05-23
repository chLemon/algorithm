# 题目链接: https://leetcode.cn/problems/edit-distance/
# 时空复杂度:
# Tags:


class Solution:

    # 三个操作 dfs(i, j)
    # 插入：dfs(i, j-1) + 1
    # 删除：dfs(i-1,j) + 1
    # 替换：dfs(i-1,j-1) + 1
    def mem_search(self, word1: str, word2: str) -> int:

        @cache
        def dfs(i, j) -> int:
            if i < 0 or j < 0:
                return 0 if i < 0 and j < 0 else max(i, j) + 1
            return (
                min(dfs(i, j - 1), dfs(i - 1, j), dfs(i - 1, j - 1)) + 1
                if word1[i] != word2[j]
                else dfs(i - 1, j - 1)
            )

        return dfs(len(word1) - 1, len(word2) - 1)

    # f[i + 1][j + 1] = min(f[i][j + 1], f[i + 1][j], f[i][j]) + 1 if s != t else f[i][j]
    def f(self, word1: str, word2: str) -> int:
        n, m = len(word1), len(word2)
        # 注意这里！！！！
        f = list(range(m + 1))
        for i, x in enumerate(word1):
            pre = i
            f[0] = i + 1
            for j, y in enumerate(word2):
                tmp = f[j + 1]
                f[j + 1] = (min(f[j + 1], f[j], pre) + 1) if x != y else pre
                pre = tmp
        return f[-1]

    def minDistance(self, word1: str, word2: str) -> int:
        return self.f(word1=word1, word2=word2)

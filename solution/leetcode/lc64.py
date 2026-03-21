# 题目链接: https://leetcode.cn/problems/minimum-path-sum/description/
# 时空复杂度: O(mn) O(mn) 空间还可以用背包优化
# Tags:

from math import inf


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        f = [[inf] * (n + 1) for _ in range(m + 1)]
        f[0][1] = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                f[i][j] = min(f[i - 1][j], f[i][j - 1]) + grid[i - 1][j - 1]
        return int(f[m][n])

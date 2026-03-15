# 题目链接: https://leetcode.cn/problems/n-queens/description/
# 时空复杂度: O(n^2 * n!)
# Tags:


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        ans = []
        queens = [0] * n
        on_col = [False] * n
        diag1 = [False] * (2 * n)  # r + c
        diag2 = [False] * (2 * n)  # r - c

        def dfs(r):
            if r == n:
                ans.append(["." * c + "Q" + "." * (n - c - 1) for c in queens])
                return
            for j in range(n):
                if not on_col[j] and not diag1[j + r] and not diag2[j - r]:
                    queens[r] = j
                    on_col[j] = diag1[j + r] = diag2[j - r] = True
                    dfs(r + 1)
                    on_col[j] = diag1[j + r] = diag2[j - r] = False

        dfs(0)
        return ans

# 题目链接: https://leetcode.cn/problems/n-queens-ii/description/
# 时空复杂度: O(n * n!)
# Tags:


class Solution:
    def totalNQueens(self, n: int) -> int:
        ans = 0
        on_col = [False] * n
        diag1 = [False] * (2 * n)
        diag2 = [False] * (2 * n)

        def dfs(r):
            if r == n:
                nonlocal ans
                ans += 1
                return

            for c in range(n):
                if not on_col[c] and not diag1[r + c] and not diag2[r - c]:
                    on_col[c] = diag1[r + c] = diag2[r - c] = True
                    dfs(r + 1)
                    on_col[c] = diag1[r + c] = diag2[r - c] = False

        dfs(0)
        return ans

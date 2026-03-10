# 题目链接: https://leetcode.cn/problems/combinations/description/
# 时空复杂度: O(n * C(n, k))
# Tags:

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        ans = []
        path = [0] * k

        # i: 问题规模 m:当前最大可选数
        # 组合问题，其实不需要问题规模 i
        def dfs(i, m):
            if i == k:
                ans.append(path.copy())
                return
            # 倒序，便于剪枝
            for j in range(m, k - i - 1, -1):
                path[i] = j
                dfs(i + 1, j - 1)
        dfs(0, n)
        return ans
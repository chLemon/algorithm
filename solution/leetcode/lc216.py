# 题目链接: https://leetcode.cn/problems/combination-sum-iii/description/
# 时空复杂度:
# Tags:

class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        ans = []
        path = []
        # 问题规模会随着递归栈缩小，i表示能用的最大的数
        def dfs(i, sum):
            r = k - len(path)
            if sum > n or (sum + (i + i - r + 1) * r // 2) < n:
                return
            if r == 0:
                ans.append(path.copy())
                return
            for j in range(i, r - 1, -1):
                path.append(j)
                dfs(j - 1, sum + j)
                path.pop()
        dfs(9, 0)
        return ans

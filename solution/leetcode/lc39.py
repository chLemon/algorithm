# 题目链接: https://leetcode.cn/problems/combination-sum/
# 时空复杂度:
# Tags:


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        path = []

        def dfs(i, sum):
            if sum == target:
                ans.append(path.copy())
                return
            if sum > target or i >= len(candidates):
                return

            # 不选
            dfs(i + 1, sum)

            # 选
            path.append(candidates[i])
            dfs(i, sum + candidates[i])
            path.pop()

        dfs(0, 0)
        return ans

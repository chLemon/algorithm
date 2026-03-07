# 题目链接: https://leetcode.cn/problems/subsets/description/
# 时空复杂度: O(n * 2^n) O(n)
# Tags: 回溯


class Solution:
    def choose_or_non(self, nums: List[int]) -> List[List[int]]:
        ans = []
        n = len(nums)
        path = []

        def dfs(i):
            if i == n:
                ans.append(path.copy())
                return
            dfs(i + 1)

            path.append(nums[i])
            dfs(i + 1)
            path.pop()

        dfs(0)
        return ans

    def choose_which(self, nums: List[int]) -> List[List[int]]:
        ans = []
        n = len(nums)
        path = []

        def dfs(i):
            ans.append(path.copy())
            for j in range(i, n):
                path.append(nums[j])
                dfs(j + 1)
                path.pop()

        dfs(0)
        return ans

    def subsets(self, nums: List[int]) -> List[List[int]]:
        return self.choose_which(nums)

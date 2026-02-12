# 题目链接: https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
# 时空复杂度: O(n * 4^n) O(n_)
# Tags: 回溯，只在最后加入答案的回溯，可以直接覆盖，不恢复现场

MAPPING = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        n = len(digits)
        path = [''] * n
        ans = []

        def dfs(i):
            if i == n:
                ans.append(''.join(path))
                return
            for w in MAPPING[int(digits[i])]:
                path[i] = w
                dfs(i + 1)
        dfs(0)
        return ans

# 题目链接: https://leetcode.cn/problems/palindrome-partitioning/description/
# 时空复杂度:
# Tags:

class Solution:

    # 选和不选
    def method1(self, s: str) -> List[List[str]]:
        ans = []
        n = len(s)
        path = []

        def dfs(i, start):
            if i == n:
                ans.append(path.copy())
                return

            # 不选
            dfs(i + 1, start)

            # 选
            # 判断是否是回文串
            t = s[start: i]
            if t == t[::-1]:
                path.append(s[start: i])
                dfs(i + 1, i)
                path.pop()

        dfs(0, 0)
        return ans



    def partition(self, s: str) -> List[List[str]]:
        return self.method1(s)
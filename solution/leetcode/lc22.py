# 题目链接: https://leetcode.cn/problems/generate-parentheses/description/
# 时空复杂度:
# Tags:


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        path = []

        # 选和不选
        def dfs(i):
            l = len(path)
            if l == n * 2:
                ans.append(''.join(path))
                return

            if i > 0:
                # 左括号可以选
                path.append("(")
                dfs(i - 1)
                path.pop()
            # 左括号不选，选右括号
            if (l - (n - i)) < (n - i):
                path.append(")")
                dfs(i)
                path.pop()

        dfs(n)
        return ans

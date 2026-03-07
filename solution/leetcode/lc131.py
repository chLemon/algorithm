# 题目链接: https://leetcode.cn/problems/palindrome-partitioning/description/
# 时空复杂度: O(n * 2^n) O(n)
# Tags: 回溯


class Solution:

    # 选和不选
    def choose_or_not(self, s: str) -> List[List[str]]:
        ans = []
        path = []
        n = len(s)

        # 选和不选 s[i - 1], [i] 处的逗号
        def dfs(i, start):
            t = s[start:i]
            if i == n:
                if t == t[::-1]:
                    path.append(s[start:i])
                    ans.append(path.copy())
                    path.pop()
                    return
                return
            if t == t[::-1]:
                path.append(s[start:i])
                dfs(i + 1, i)
                path.pop()
            dfs(i + 1, start)

        dfs(1, 0)
        return ans

    # 选哪个
    def choose_which(self, s: str) -> List[List[str]]:
        ans = []
        path = []
        n = len(s)

        # 选哪个，换个语义试试，考虑 s[i:] 怎么分割
        def dfs(i):
            if i == n:
                ans.append(path.copy())
                return
            # 选 s[j] s[j+1] 的逗号
            for j in range(i, n):
                t = s[i : j + 1]
                if t == t[::-1]:
                    path.append(t)
                    dfs(j + 1)
                    path.pop()

        dfs(0)
        return ans

    def partition(self, s: str) -> List[List[str]]:
        return self.choose_which(s)

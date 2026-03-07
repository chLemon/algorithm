# 题目链接: https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/description/
# 时空复杂度:
# Tags:

PRE_SUM = [0] * 1001


def isPunishment(i: int) -> bool:
    s = str(i * i)
    n = len(s)
    path = []

    def dfs(p):
        if p == n:
            return sum(int(e) for e in path) == i
        for j in range(p, n):
            path.append(s[p : j + 1])
            if dfs(j + 1):
                return True
            path.pop()
        return False

    return dfs(0)


for i in range(1, 1001):
    PRE_SUM[i] = PRE_SUM[i - 1] + (i * i if isPunishment(i) else 0)


class Solution:
    def punishmentNumber(self, n: int) -> int:
        return PRE_SUM[n]

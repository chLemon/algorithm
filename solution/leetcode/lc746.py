# 题目链接: https://leetcode.cn/problems/min-cost-climbing-stairs/description/
# 时空复杂度:
# Tags:


class Solution:
    # f[n] = min(f[n-1] + cost[n-1], f[n-2] + cost[n-2])
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        f0 = f1 = 0
        for i in range(2, n + 1):
            f0, f1 = f1, min(f1 + cost[i - 1], f0 + cost[i - 2])
        return f1

# 题目链接: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
# 时空复杂度:
# Tags:


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i in range(len(prices) - 1):
            if prices[i + 1] > prices[i]:
                profit += prices[i + 1] - prices[i]
        return profit

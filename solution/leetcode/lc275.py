# 题目链接: https://leetcode.cn/problems/h-index-ii/
# 时空复杂度: O(logn) O(1)
# Tags: 二分查找；二分答案；推荐用开区间二分，满足条件时更新的是哪个变量，就返回哪个变量。


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        # 这里的初始值，还可以继续优化一下，比如说 0 不可能是答案
        l, r = -1, n + 1
        while l + 1 < r:
            m = (l + r) // 2
            if citations[-m] >= m:
                # 满足，则 h 指数会更大。且此时 [0, l] 都是满足的
                l = m
            else:
                # 不满足，则 h 指数会更小
                r = m
        return l

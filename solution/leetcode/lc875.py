# 题目链接: https://leetcode.cn/problems/koko-eating-bananas/
# 时空复杂度: O(n logU)，U为 max(piles) O(1)
# Tags: 二分答案


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # 答案的范围在 max 和 1 之间
        l, r = 0, max(piles) # 这里其实就可以给出来 l r 的情况了，l 的结果恒为不满足，r 恒为满足
        while l + 1 < r:
            m = (l + r) // 2
            # m 是否满足要求
            if sum((i - 1) // m + 1 for i in piles) <= h:
                # 可以吃完，可以再慢一点
                r = m
            else:
                # 吃不完了，快一点
                l = m
        return r
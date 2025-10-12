# 题目链接: https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/description/
# 时空复杂度: O(n logn) 排序 + O(n logU)
# Tags: 二分答案，最大化最小值


class Solution:
    def maximumTastiness(self, price: List[int], k: int) -> int:
        # 答案范围: [0, (max(price)-min(price)) // (k - 1)]
        price.sort()
        left, right = -1, (price[-1] - price[0]) // (k - 1) + 1
        # l 为 可以满足的区间, r 恒为 False
        while left + 1 < right:
            mid = (left + right) // 2

            def check(honey):
                # 当前甜蜜度是否能满足
                # 关于甜蜜度能否满足的问题，亦此处二分的单调性问题。
                # 由于 甜蜜度 是离散的，此处定义了 f(d) 为 甜蜜度至少为 d 时，最多可以选择糖果的种类，则 f(d) >= k 时，答案至少为 d，f(d) < k 时，答案最多为 d - 1
                last = price[0]
                need = k - 1
                for p in price:
                    if p - last >= honey:
                        last = p
                        need -= 1
                return need <= 0

            if check(mid):
                # 说明甜蜜度可以满足，可以继续放大
                left = mid
            else:
                right = mid
        return left

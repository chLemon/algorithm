# 题目链接: https://leetcode.cn/problems/count-the-number-of-fair-pairs/description/
# 时空复杂度: O(n log n) O(1)
# Tags: 二分查找

import bisect
from typing import List


class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        nums.sort()
        ans = 0
        for j, x in enumerate(nums):
            # i 的取值范围是 [0, j - 1]
            idx_lower = bisect.bisect_left(nums, lower - x, 0, j)
            idx_upper = bisect.bisect_left(nums, upper - x + 1, 0, j)
            ans += idx_upper - idx_lower

        return ans

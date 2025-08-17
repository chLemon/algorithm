# 题目链接: https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/description/
# 时空复杂度: O(log n) O(1)
# Tags: 二分查找

import bisect

class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        idx0 = bisect.bisect_left(nums, 0)
        idx1 = bisect.bisect_left(nums, 1)
        return max(idx0, len(nums) - idx1)

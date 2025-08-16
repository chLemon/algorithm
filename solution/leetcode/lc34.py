# 题目链接: https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
# 时空复杂度: O(log n) O(1)
# Tags: 二分查找

from typing import List


class Solution:
    def lower_bound(self, nums: List[int], target: int):
        # bisect.bisect_left
        l, r = -1, len(nums)
        while l + 1 < r:
            mid = l + (r - l) // 2
            if nums[mid] < target:
                l = mid
            else:
                r = mid
        return r

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start = self.lower_bound(nums, target)
        if start == len(nums) or nums[start] != target:
            return [-1, -1]
        end = self.lower_bound(nums, target + 1)
        return [start, end - 1]

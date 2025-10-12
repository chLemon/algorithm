# 题目链接: https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/
# 时空复杂度: O(log n) O(1)
# Tags: 二分查找

class Solution:
    def findMin(self, nums: List[int]) -> int:
        # 左侧，在最小值的左边，右侧，最小值，或者在最小值的右边
        left, right = -1, len(nums) - 1
        while left + 1 < right:
            mid = (left + right) // 2
            if nums[mid] > nums[-1]:
                # 一定在最小值左边
                left = mid
            else:
                right = mid
        return nums[right]

# 题目链接: https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/description/
# 时空复杂度: O(n) O(1)
# Tags: 二分查找


class Solution:
    def findMin(self, nums: List[int]) -> int:
        # left 最小值左边，right 最小值或最小值右边
        left, right = -1, len(nums) - 1
        # 这里也可以在 while 里， right -= 1
        while left + 1 < len(nums) and nums[left + 1] == nums[-1]:
            left += 1
        while left + 1 < right:
            mid = (left + right) // 2
            if nums[mid] > nums[-1]:
                left = mid
            else:
                right = mid
        return nums[right]

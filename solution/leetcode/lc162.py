# 题目链接: https://leetcode.cn/problems/find-peak-element/description/
# 时空复杂度: O(log n) O(1)
# Tags: 二分查找


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # 二分，left 的区间都是峰值左侧的，right 区间则是 峰值 或 峰值右侧的
        left, right = -1, len(nums) - 1
        while left + 1 < right:
            mid = (left + right) // 2
            # 比较和 mid + 1
            if nums[mid] < nums[mid + 1]:
                left = mid
            else:
                right = mid
        return right

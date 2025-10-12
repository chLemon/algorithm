# 题目链接: https://leetcode.cn/problems/search-in-rotated-sorted-array/description/
# 时空复杂度: O(log n) O(1)
# Tags: 二分查找


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # 这道题能二分的本质是因为，我们可以通过一系列判断，知道 nums[mid] 在 target 的左边还是右边
        # 那么先看 target 和 二分点 在不在同一段上，如果2个都大于x 或者都小于等于 x
        # 否则就是在 不同段 上，分开处理即可
        # 灵神写的更精彩
        left = -1
        right = len(nums)
        x = nums[-1]
        while left + 1 < right:
            mid = (left + right) // 2
            if (nums[mid] > x and target > x) or (nums[mid] <= x and target <= x):
                # 同一段上
                if nums[mid] < target:
                    left = mid
                else:
                    right = mid
            else:
                # 不同段上
                if nums[mid] > target:
                    left = mid
                else:
                    right = mid
        return right if nums[right] == target else -1

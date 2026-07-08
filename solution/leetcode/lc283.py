# 题目链接: https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=top-100-liked
# 时空复杂度:
# Tags:


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = j = 0
        n = len(nums)
        while i < n:
            while j < n and nums[j] == 0:
                j += 1
            if j >= n:
                nums[i] = 0
                i += 1
            else:
                nums[i] = nums[j]
                i += 1
                j += 1

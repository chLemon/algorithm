# 题目链接: https://leetcode.cn/problems/sorting-three-groups/description/
# 时空复杂度:
# Tags:

class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        count = 0
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                count += 1
        return count
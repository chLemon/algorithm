# 题目链接: https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
# 时空复杂度:
# Tags:


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        m = {}
        for i, x in enumerate(nums):
            if target - x in m:
                return [m[target - x], i]
            m[x] = i

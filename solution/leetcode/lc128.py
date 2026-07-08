# 题目链接: https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
# 时空复杂度:
# Tags:


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums_set = set(nums)
        ans = 0
        for x in nums_set:
            if x - 1 in nums_set:
                continue
            # x 是序列的起点
            y = x + 1
            while y in nums_set:
                y += 1
            ans = max(ans, y - x)
        return ans
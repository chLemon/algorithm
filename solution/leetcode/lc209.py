# https://leetcode.cn/problems/minimum-size-subarray-sum/description/
# O(n) O(1)
# 滑动窗口


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        l = sum = 0
        ans = n + 1
        # [l, r]
        for r, x in enumerate(nums):
            sum += x
            while sum >= target:
                ans = min(ans, r - l + 1)
                sum -= nums[l]
                l += 1
        return ans if ans != n + 1 else 0

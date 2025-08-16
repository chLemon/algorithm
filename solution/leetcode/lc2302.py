# https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/
# O(n) O(1)
# 滑动窗口，同向双指针

from typing import List

class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        ans = left = sum = 0
        for right, x in enumerate(nums):
            sum += x
            while sum * (right - left + 1) >= k:
                sum -= nums[left]
                left += 1
            ans += right - left + 1
        return ans
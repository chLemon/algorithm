# https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/
# O(n) O(n)
# 同向双指针，重点在于有可能会破坏子数组特性的，一定是新加入的

from collections import Counter

class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        left = ans = 0
        cnt = Counter()
        for right, x in enumerate(nums):
            cnt[x] += 1
            while cnt[x] > k:
                cnt[nums[left]] -= 1
                left += 1
            ans = max(ans, right - left + 1)
        return ans

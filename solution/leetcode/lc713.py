# https://leetcode.cn/problems/subarray-product-less-than-k/
# O(n) O(1)
# 相向双指针

class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        left = ans = 0
        prod = 1
        for right, x in enumerate(nums):
            prod *= x
            while prod >= k:
                prod //= nums[left]
                left += 1
            ans += right - left + 1
        return ans
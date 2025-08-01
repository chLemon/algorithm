# https://leetcode.cn/problems/max-consecutive-ones-iii/
# O(n) O(1)
# 同向双指针/滑动窗口


class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        # 问题可以转换为，一个连续子数组里，最多有 k 个 0，求最长
        ans = left = zero_count = 0
        for right, x in enumerate(nums):
            if x == 0:
                zero_count += 1
            # 这里可以直接写成 zero_count += 1 - x
            while zero_count > k:
                if nums[left] == 0:
                    zero_count -= 1
                left += 1
            ans = max(ans, right - left + 1)
        return ans

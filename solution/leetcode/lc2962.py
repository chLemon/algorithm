# https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/
# O(n) O(1)
# 越长越合法，滑动窗口


class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_num = max(nums)
        cnt_max = ans = left = 0

        for x in nums:
            if x == max_num:
                cnt_max += 1
            while cnt_max >= k:
                if nums[left] == max_num:
                    cnt_max -= 1
                left += 1
            ans += left
        return ans

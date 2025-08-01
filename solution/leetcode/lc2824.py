# https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/
# O(nlogn) O(1)
# 相向双指针
class Solution:
    def countPairs(self, nums: List[int], target: int) -> int:
        nums.sort()
        ans = left = 0
        right = len(nums) - 1
        while left < right:
            if nums[left] + nums[right] < target:
                ans += right - left
                left += 1
            else:
                right -= 1
        return ans
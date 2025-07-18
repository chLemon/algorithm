# https://leetcode.cn/problems/3sum-closest/description/
# O(n^2) O(1)
# 相向双指针
from math import inf
from typing import List


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        n = len(nums)
        min_diff_abs = inf
        for i in range(n - 2):
            # 双指针
            j, k = i + 1, n - 1
            while j < k:
                s = nums[i] + nums[j] + nums[k]
                if s == target:
                    return s
                if s > target:
                    if s - target < min_diff_abs:  # s 与 target 更近
                        min_diff_abs = s - target
                        ans = s
                    k -= 1
                else:  # s < target
                    if target - s < min_diff_abs:  # s 与 target 更近
                        min_diff_abs = target - s
                        ans = s
                    j += 1
        return ans

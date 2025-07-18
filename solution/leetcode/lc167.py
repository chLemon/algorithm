# https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
# O(n) O(1)
# 相向双指针


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left = 0
        right = len(numbers) - 1
        while left < right:
            s = numbers[left] + numbers[right]
            if s == target:
                return [left + 1, right + 1]
            elif s < target:
                left += 1
            elif s > target:
                right -= 1

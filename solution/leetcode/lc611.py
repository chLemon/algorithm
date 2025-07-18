# https://leetcode.cn/problems/valid-triangle-number/description/
# O(n^2) O(1)
# 枚举最长边+相向双指针
class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums.sort()
        # 两边之和大于第三边
        count = 0
        n = len(nums)
        for c in range(2, n):
            a = 0
            b = c - 1
            while a < b:
                if nums[a] + nums[b] > nums[c]:
                    # 寻到了答案
                    count += b - a
                    b -= 1
                else:
                    a += 1

        return count

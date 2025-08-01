# https://leetcode.cn/problems/maximum-beauty-of-an-array-after-applying-operation/
# O(nlogn) O(1)
# 同向双指针，注意子序列不要求顺序，所以可以排序，从而转换问题


class Solution:
    def maximumBeauty(self, nums: List[int], k: int) -> int:
        # 对于每一个数字，相当于是 [x-k, x+k] 的区间，求的是这些区间里有交集的最大个数
        # 由于是子序列，所以顺序不重要，那么先排序好后，如果一个子序列都有交集，那么第一个和最后一个肯定有交集。x+k >= y-k,  y-x <= 2k
        # 问题就变成了，最大的子数组，满足 y-x <= 2k 的
        nums.sort()
        ans = left = 0
        for right, x in enumerate(nums):
            while x - nums[left] > 2 * k:
                left += 1
            ans = max(ans, right - left + 1)
        return ans

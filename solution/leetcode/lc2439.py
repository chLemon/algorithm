# 题目链接: https://leetcode.cn/problems/minimize-maximum-of-array/description/
# 时空复杂度: O(n) O(1) / O(n logU), U = max(nums) O(1)
# Tags: 分类讨论 / 二分


class Solution:
    def bi(self, nums: List[int]) -> int:
        # 二分答案，答案一定在 nums[0] 和 max(nums) 中
        # 答案的校验：从右边往左模拟
        left = nums[0] - 1  # 恒为 False
        right = max(nums) + 1  # 恒为 True

        def check(limit: int) -> bool:
            over = 0
            for i in range(len(nums) - 1, 0, -1):
                over = max(0, nums[i] + over - limit)
            return over + nums[0] <= limit

        while left + 1 < right:
            mid = (left + right) // 2
            if check(mid):
                # 可以，继续下探
                right = mid
            else:
                left = mid
        return right

    def mock(self, nums: List[int]) -> int:
        # 从左到右分类讨论模拟试探
        ans = total = nums[0]
        for i in range(1, len(nums)):
            total += nums[i]
            ans = max(ans, (total + i) // (i + 1))
        return ans

    def minimizeArrayValue(self, nums: List[int]) -> int:
        return self.mock(nums)

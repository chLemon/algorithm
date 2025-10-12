# 题目链接: https://leetcode.cn/problems/search-a-2d-matrix/description/
# 时空复杂度: O(log m) + O(log n) / O(m + n)
# Tags: 二分查找


class Solution:

    # 先找到可能所在的行，再判断
    def sol1(self, matrix: List[List[int]], target: int) -> bool:
        left, right = -1, len(matrix)
        while left + 1 < right:
            mid = (left + right) // 2
            m = matrix[mid][0]
            if m < target:
                left = mid
            else:
                right = mid
        # 判断是否已经找到
        if right < len(matrix) and matrix[right][0] == target:
            return True
        # right - 1 是可能所在的行
        nums = matrix[right - 1]
        left, right = -1, len(nums)
        while left + 1 < right:
            mid = (left + right) // 2
            if nums[mid] < target:
                left = mid
            else:
                right = mid
        # right 是可能所在的位置
        return right < len(nums) and nums[right] == target

    # 直接整体做二分
    def sol2(self, matrix: List[List[int]], target: int) -> bool:
        # 第 i 个元素，位于 i // n 行， i % n 列
        m, n = len(matrix), len(matrix[0])
        left, right = -1, m * n
        while left + 1 < right:
            mid = (left + right) // 2
            x = matrix[mid // n][mid % n]
            if x == target:
                return True
            elif x < target:
                left = mid
            else:
                right = mid
        return False

    # 从右上角/左下角开始判断
    # 真是人才，不过这个复杂度稍高
    def sol3(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        i, j = 0, n - 1
        while i < m and j >= 0:
            x = matrix[i][j]
            if x == target:
                return True
            elif x > target:
                # 这个数比目标大，说明这一列都不行
                j -= 1
            else:
                # 这个数比目标小，说明这一行都不行
                i += 1
        return False

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        return self.sol3(matrix, target)

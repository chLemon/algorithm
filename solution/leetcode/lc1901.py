# 题目链接: https://leetcode.cn/problems/find-a-peak-element-ii/description/
# 时空复杂度: O(n log m) O(1)
# Tags: 二分查找


class Solution:

    # 人往高处走
    # 果然这种巧妙地算法，基础还是得想一下暴力解怎么做
    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        left, right = -1, len(mat) - 1
        while left + 1 < right:
            mid = (left + right) // 2
            mx = max(mat[mid])
            if mx < mat[mid + 1][mat[mid].index(mx)]:
                left = mid
            else:
                right = mid
        return [right, mat[right].index(max(mat[right]))]

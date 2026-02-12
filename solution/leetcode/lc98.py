# 题目链接: https://leetcode.cn/problems/validate-binary-search-tree/description/
# 时空复杂度: O(n) O(n)
# Tags:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode], l_limit=-inf, r_limit=inf) -> bool:
        if root is None:
            return True
        return (
            l_limit < root.val < r_limit
            and self.isValidBST(root.left, l_limit, root.val)
            and self.isValidBST(root.right, root.val, r_limit)
        )

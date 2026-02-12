# 题目链接: https://leetcode.cn/problems/symmetric-tree/description/
# 时空复杂度: O(n) O(n)
# Tags:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True

        def is_symmetric(l, r):
            if l is None or r is None:
                return l is r
            return (
                l.val == r.val
                and is_symmetric(l.right, r.left)
                and is_symmetric(l.left, r.right)
            )

        return is_symmetric(root.left, root.right)

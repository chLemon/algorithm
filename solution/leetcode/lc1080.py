# 题目链接: https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/description/
# 时空复杂度: O(n) O(n)
# Tags:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sufficientSubset(
        self, root: Optional[TreeNode], limit: int
    ) -> Optional[TreeNode]:
        limit -= root.val
        if root.left is None and root.right is None:
            return None if limit > 0 else root
        if root.left:
            root.left = self.sufficientSubset(root.left, limit)
        if root.right:
            root.right = self.sufficientSubset(root.right, limit)
        return root if root.left or root.right else None

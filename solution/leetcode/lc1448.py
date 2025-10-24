# 题目链接: https://leetcode.cn/problems/count-good-nodes-in-binary-tree/
# 时空复杂度: O(n) O(n)
# Tags:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: Optional[TreeNode], mx=-inf) -> int:
        if root is None:
            return 0
        mx = max(mx, root.val)
        return (
            self.goodNodes(root.left, mx)
            + self.goodNodes(root.right, mx)
            + (root.val >= mx)
        )

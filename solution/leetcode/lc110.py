# 题目链接: https://leetcode.cn/problems/balanced-binary-tree/description/
# 时空复杂度: O(n) O(n)
# Tags:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def is_balanced_return_height(node: Optional[TreeNode]) -> int:
            if node is None:
                return 0
            left_height = is_balanced_return_height(node.left)
            right_height = is_balanced_return_height(node.right)
            if left_height == -1 or right_height == -1 or abs(left_height - right_height) > 1:
                return -1
            return max(left_height, right_height) + 1
        return is_balanced_return_height(root) != -1

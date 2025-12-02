# 题目链接: https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
# 时空复杂度: O(n) O(n)
# Tags:

from typing import List


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        index = {x: i for i, x in enumerate(inorder)}

        def buildTree(pre_l, pre_r, in_l, in_r):
            if pre_l >= pre_r:
                return None
            # 中左右  左中右
            left_len = index[preorder[pre_l]] - in_l
            return TreeNode(
                preorder[pre_l],
                buildTree(pre_l + 1, pre_l + 1 + left_len, in_l, in_l + left_len),
                buildTree(pre_l + 1 + left_len, pre_r, in_l + 1 + left_len, in_r),
            )

        return buildTree(0, len(preorder), 0, len(inorder))

# 题目链接: https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
# 时空复杂度: O(n) O(n)
# Tags:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # 左中右 左右中
        index = {x: i for i, x in enumerate(inorder)}

        def dfs(in_l, in_r, po_l, po_r):
            if in_l >= in_r:
                return None
            left_len = index[postorder[po_r - 1]] - in_l
            return TreeNode(
                postorder[po_r - 1],
                dfs(in_l, in_l + left_len, po_l, po_l + left_len),
                dfs(in_l + 1 + left_len, in_r, po_l + left_len, po_r - 1),
            )

        return dfs(0, len(inorder), 0, len(postorder))

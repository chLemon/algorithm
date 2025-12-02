# 题目链接: https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
# 时空复杂度: O(n) O(n)
# Tags:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def constructFromPrePost(
        self, preorder: List[int], postorder: List[int]
    ) -> Optional[TreeNode]:
        index = {x: i for i, x in enumerate(postorder)}

        # 中左右 左右中
        def dfs(pre_l, pre_r, post_l, post_r):
            if pre_l >= pre_r:
                return None
            if pre_l + 1 == pre_r:
                return TreeNode(preorder[pre_l])
            left_len = index[preorder[pre_l + 1]] - post_l + 1
            return TreeNode(
                preorder[pre_l],
                dfs(pre_l + 1, pre_l + 1 + left_len, post_l, post_l + left_len),
                dfs(pre_l + 1 + left_len, pre_r, post_l + left_len, post_r - 1),
            )

        return dfs(0, len(preorder), 0, len(postorder))

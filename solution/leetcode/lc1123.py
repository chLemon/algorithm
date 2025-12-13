# 题目链接: https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/description/
# 时空复杂度: O(n) O(n)
# Tags:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(node):
            if node is None:
                return 0, None
            left_height, left = dfs(node.left)
            right_height, right = dfs(node.right)
            if left_height == right_height:
                return left_height + 1, node
            elif left_height < right_height:
                return right_height + 1, right
            else:
                return left_height + 1, left

        return dfs(root)[1]

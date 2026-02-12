# 题目链接: https://leetcode.cn/problems/binary-tree-right-side-view/description/
# 时空复杂度: O(n) O(h)
# Tags:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        ans = []

        def right_side_view(node, depth):
            if node is None:
                return
            if depth > len(ans):
                ans.append(node.val)
            right_side_view(node.right, depth + 1)
            right_side_view(node.left, depth + 1)

        right_side_view(root, 1)
        return ans

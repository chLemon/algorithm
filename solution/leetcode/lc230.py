# 题目链接: https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/
# 时空复杂度: O(n) O(n)
# Tags:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def dfs(root: Optional[TreeNode]):
            if root is None:
                return None
            left_res = dfs(root.left)
            if left_res is not None:
                return left_res
            nonlocal k
            k -= 1
            if k == 0:
                return root.val
            return dfs(root.right)

        return dfs(root)

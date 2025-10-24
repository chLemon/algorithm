# 题目链接: https://leetcode.cn/problems/sum-root-to-leaf-numbers/
# 时空复杂度: O(n) O(n)
# Tags:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        sum = 0
        def dfs(root: Optional[TreeNode], x:int) -> None:
            if root is None:
                return
            x = x * 10 + root.val
            if root.left is None and root.right is None:
                nonlocal sum
                sum += x
                return
            dfs(root.left, x)
            dfs(root.right, x)

        dfs(root, 0)
        return sum
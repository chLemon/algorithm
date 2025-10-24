# 题目链接: https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/
# 时空复杂度: O(n logn) O(n)
# Tags:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        all = []
        def dfs(root: Optional[TreeNode], row, col):
            if root is None:
                return
            all.append((col, row, root.val))
            dfs(root.left, row + 1, col - 1)
            dfs(root.right, row + 1, col + 1)
        dfs(root, 0, 0)

        # all 排序
        all.sort()
        ans = []
        last_col = inf
        for col, _, val in all:
            if last_col != col:
                last_col = col
                ans.append([])
            ans[-1].append(val)
        return ans

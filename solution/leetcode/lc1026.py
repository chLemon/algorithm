# 题目链接: https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/
# 时空复杂度: O(n) O(n)
# Tags:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(node, mn, mx):
            if node is None:
                # 更新答案可以只在叶子节点做
                return
            mn = min(mn, node.val)
            mx = max(mx, node.val)
            nonlocal ans
            ans = max(node.val - mn, mx - node.val, ans)
            dfs(node.left, mn, mx)
            dfs(node.right, mn, mx)

        dfs(root, inf, -inf)
        return ans

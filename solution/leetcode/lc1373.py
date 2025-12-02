# 题目链接: https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/description/
# 时空复杂度: O(n) O(n)
# Tags:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(root: Optional[TreeNode]):
            if root is None:
                return (True, inf, -inf, 0)
            l_is, l_min, l_max, l_sum = dfs(root.left)
            r_is, r_min, r_max, r_sum = dfs(root.right)
            # 当前子数是否为二叉搜索树
            n_is = l_is and r_is and l_max < root.val < r_min
            n_min = min(root.val, l_min)
            n_max = max(root.val, r_max)
            n_sum = l_sum + r_sum + root.val
            if n_is:
                nonlocal ans
                ans = max(ans, n_sum)
            return (n_is, n_min, n_max, n_sum)
        dfs(root)
        return ans

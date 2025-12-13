# 题目链接: https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
# 时空复杂度: O(n) O(n)
# Tags:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        q = deque([root])

        ans = []
        while q:
            layer = []
            for _ in range(len(q)):
                node = q.popleft()
                layer.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            ans.append(layer[::-1] if len(ans) % 2 else layer)
        return ans

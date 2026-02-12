# 题目链接: https://leetcode.cn/problems/reverse-odd-levels-of-binary-tree/description/
# 时空复杂度: O(n) O(n)
# Tags:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def bfs(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return root
        q = deque([root])
        layer = 0
        while q:
            current_layer = []
            for _ in range(len(q)):
                node = q.popleft()
                if layer % 2:
                    current_layer.append(node)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            # reverse
            l, r = 0, len(current_layer) - 1
            while l < r:
                current_layer[l].val, current_layer[r].val = (
                    current_layer[r].val,
                    current_layer[l].val,
                )
                l += 1
                r -= 1
            layer += 1
        return root

    def dfs(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(left, right, reverse):
            if left is None: return
            if reverse:
                left.val, right.val = right.val, left.val
            dfs(left.left, right.right, not reverse)
            dfs(left.right, right.left, not reverse)

        dfs(root.left, root.right, True)
        return root

    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        return self.dfs(root)

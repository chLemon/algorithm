# 题目链接: https://leetcode.cn/problems/cousins-in-binary-tree-ii/description/
# 时空复杂度: O(n) O(n)
# Tags: 如果需要上一层的信息，不要在这一层处理；在上一层处理子节点即可


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        root.val = 0
        q = deque([root])

        while q:
            nxt_sum = 0
            for node in q:
                if node.left:
                    nxt_sum += node.left.val
                if node.right:
                    nxt_sum += node.right.val
            for _ in range(len(q)):
                node = q.popleft()
                brother_sum = (node.left.val if node.left else 0) + (
                    node.right.val if node.right else 0
                )

                if node.left:
                    node.left.val = nxt_sum - brother_sum
                    q.append(node.left)
                if node.right:
                    node.right.val = nxt_sum - brother_sum
                    q.append(node.right)
        return root

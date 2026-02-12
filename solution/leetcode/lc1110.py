# 题目链接: https://leetcode.cn/problems/delete-nodes-and-return-forest/description/
# 时空复杂度: O(m + n) n为节点个数，m为 to_delete 长度 O(m + n)
# Tags:


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def delNodes(
        self, root: Optional[TreeNode], to_delete: List[int]
    ) -> List[TreeNode]:
        ans = []
        s = set(to_delete)

        def dfs(node: TreeNode | None):
            if node is None:
                return None
            node.left = dfs(node.left)
            node.right = dfs(node.right)
            if node.val in s:
                if node.left:
                    ans.append(node.left)
                if node.right:
                    ans.append(node.right)
                return None
            return node

        if dfs(root):
            ans.append(root)
        return ans

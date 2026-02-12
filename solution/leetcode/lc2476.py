# 题目链接: https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree/description/
# 时空复杂度: 树节点个数n，queries长度q，O(qlogn + n) O(n)
# Tags:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from bisect import bisect_left


class Solution:
    def closestNodes(
        self, root: Optional[TreeNode], queries: List[int]
    ) -> List[List[int]]:

        arr = []

        def dfs(root: Optional[TreeNode]):
            if root is None:
                return
            dfs(root.left)
            arr.append(root.val)
            dfs(root.right)

        dfs(root)

        ans = []
        # 二分查找
        for query in queries:
            if query < arr[0]:
                # 不存在小于等于的最大值
                ans.append([-1, arr[0]])
            elif query > arr[-1]:
                # 不存在大于等于的最小值
                ans.append([arr[-1], -1])
            else:
                idx = bisect_left(arr, query)
                if arr[idx] == query:
                    ans.append([arr[idx], arr[idx]])
                else:
                    ans.append([arr[idx - 1], arr[idx]])
        return ans

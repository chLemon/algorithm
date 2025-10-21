# 题目链接: https://leetcode.cn/problems/delete-node-in-a-linked-list/description/
# 时空复杂度: O(1) O(1)
# Tags: 脑筋急转弯

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next
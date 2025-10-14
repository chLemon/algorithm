# 题目链接: https://leetcode.cn/problems/reverse-linked-list-ii/description/
# 时空复杂度:
# Tags:


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        left_node = dummy
        for _ in range(left):
            left_node = left_node.next

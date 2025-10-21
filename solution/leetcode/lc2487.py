# 题目链接: https://leetcode.cn/problems/remove-nodes-from-linked-list/description/
# 时空复杂度: O(n) O(1)
# Tags:

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pre, cur = None, head
        while cur:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        rev = pre
        while pre.next:
            if pre.val > pre.next.val:
                pre.next = pre.next.next
            else:
                pre = pre.next
        pre, cur = None, rev
        while cur:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        return pre
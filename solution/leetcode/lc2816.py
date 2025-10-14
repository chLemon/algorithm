# 题目链接: https://leetcode.cn/problems/double-a-number-represented-as-a-linked-list/description/
# 时空复杂度: O(n) O(1)
# Tags:


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def revert(self, head: Optional[ListNode]):
        pre, cur = None, head
        while cur:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        return pre

    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        reverted = self.revert(head)
        dummy = cur = ListNode()
        carry = 0
        while carry or reverted:
            if reverted:
                carry += reverted.val * 2
            cur.next = ListNode(val=carry % 10)
            cur = cur.next
            carry = carry // 10
            if reverted:
                reverted = reverted.next
        return self.revert(dummy.next)

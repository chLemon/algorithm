# 题目链接: https://leetcode.cn/problems/add-two-numbers-ii/description/
# 时空复杂度: O(n) O(1)
# Tags: 反转链表


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def revert(self, l: Optional[ListNode]):
        pre, cur = None, l
        while cur:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        return pre

    def addTwoNumbers(
        self, l1: Optional[ListNode], l2: Optional[ListNode]
    ) -> Optional[ListNode]:
        revert_l1 = self.revert(l1)
        revert_l2 = self.revert(l2)

        # 相加，并构建结果
        dummy = cur = ListNode()
        carry = 0
        while revert_l1 or revert_l2 or carry:
            if revert_l1:
                carry += revert_l1.val
            if revert_l2:
                carry += revert_l2.val
            cur.next = ListNode(carry % 10)
            cur = cur.next
            carry = carry // 10
            if revert_l1: revert_l1 = revert_l1.next
            if revert_l2: revert_l2 = revert_l2.next
        return self.revert(dummy.next)

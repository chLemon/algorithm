# 题目链接: https://leetcode.cn/problems/reverse-linked-list-ii/description/
# 时空复杂度: O(right) O(1)
# Tags:


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def reverseBetween(
        self, head: Optional[ListNode], left: int, right: int
    ) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        pre_left = dummy
        for _ in range(left - 1 ):
            pre_left = pre_left.next
        pre, cur = None, pre_left.next
        for _ in range(right - left + 1):
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        pre_left.next.next = cur
        pre_left.next = pre
        return dummy.next
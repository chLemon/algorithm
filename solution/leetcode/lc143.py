# 题目链接: https://leetcode.cn/problems/reorder-list/description/
# 时空复杂度: O(n) O(1)
# Tags: 快慢指针的各种结合


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        dummy = ListNode(next=head)
        slow = fast = dummy
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        dummy.next = None
        # 此时断开 slow.next ，并且反转 slow.next 即可
        half = slow.next
        slow.next = None
        # 反转
        pre, cur = None, half
        while cur:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        # pre 是反转后的部分
        while pre:
            one_next = head.next
            two_next = pre.next
            head.next = pre
            pre.next = one_next
            head = one_next
            pre = two_next
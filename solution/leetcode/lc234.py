# 题目链接: https://leetcode.cn/problems/palindrome-linked-list/description/
# 时空复杂度: O(n) O(1)
# Tags: 快慢指针应用

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        pre = None
        while slow:
            nxt = slow.next
            slow.next = pre
            pre = slow
            slow = nxt
        while pre:
            if pre.val != head.val:
                return False
            pre = pre.next
            head = head.next
        return True
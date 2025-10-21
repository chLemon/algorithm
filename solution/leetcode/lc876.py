# 题目链接: https://leetcode.cn/problems/middle-of-the-linked-list/description/
# 时空复杂度: O(n) O(1)
# Tags: 快慢指针

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow

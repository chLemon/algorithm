# 题目链接: https://leetcode.cn/problems/linked-list-cycle/description/
# 时空复杂度: O(n) O(1)
# Tags: 快慢指针

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow is fast:
                return True
        return False

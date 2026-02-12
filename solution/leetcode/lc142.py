# 题目链接: https://leetcode.cn/problems/linked-list-cycle-ii/description/
# 时空复杂度: O(n) O(1)
# Tags: 快慢指针 Floyd判圈算法

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow is fast:
                while slow is not head:
                    head = head.next
                    slow = slow.next
                return slow
        return None

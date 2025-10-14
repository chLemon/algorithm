# 题目链接: https://leetcode.cn/problems/swap-nodes-in-pairs/
# 时空复杂度: O(n) O(1)
# Tags:

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pre = dummy = ListNode(next=head)
        one = head
        while one and one.next:
            two = one.next
            pre.next = two
            one.next = two.next
            two.next = one

            pre = one
            one = pre.next
        return dummy.next

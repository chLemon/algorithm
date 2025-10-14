# 题目链接: https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
# 时空复杂度: O(n) O(1)
# Tags:

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        cur = head
        cnt = 0
        while cur:
            cnt += 1
            cur = cur.next
        dummy = pre_group = ListNode(next=head)
        for _ in range(cnt // k):
            pre, cur = None, pre_group.next
            # k个一组
            for __ in range(k):
                nxt = cur.next
                cur.next = pre
                pre = cur
                cur = nxt
            new_pre_group = pre_group.next
            new_pre_group.next = cur
            pre_group.next = pre
            pre_group = new_pre_group
        return dummy.next

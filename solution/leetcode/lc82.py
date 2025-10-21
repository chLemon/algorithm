# 题目链接: https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
# 时空复杂度: O(n) O(1)
# Tags:

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = dummy = ListNode(next=head)
        while cur.next and cur.next.next:
            if cur.next.val == cur.next.next.val:
                v = cur.next.val
                # 要删掉所有的 val 的节点
                while cur.next and cur.next.val == v:
                    cur.next = cur.next.next
            else:
                cur = cur.next
        return dummy.next
# 题目链接: https://leetcode.cn/problems/delete-nodes-from-linked-list-present-in-array/description/
# 时空复杂度: O(n + m) O(1)
# Tags:

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        nums_set = set(nums)
        cur = dummy = ListNode(next=head)
        while cur.next:
            if cur.next.val in nums_set:
                cur.next = cur.next.next
            else:
                cur = cur.next
        return dummy.next
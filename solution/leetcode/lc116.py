# 题目链接: https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/
# 时空复杂度: O(n) O(1)
# Tags:

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        cur = root
        while cur:
            nxt = dummy = Node()
            while cur:
                if cur.left:
                    nxt.next = cur.left
                    nxt = nxt.next
                if cur.right:
                    nxt.next = cur.right
                    nxt = nxt.next
                cur = cur.next
            cur = dummy.next
        return root

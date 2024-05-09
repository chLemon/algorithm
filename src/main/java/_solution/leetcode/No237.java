package _solution.leetcode;

import _solution.inf.ListNode;

class No237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

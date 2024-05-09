package _solution.leetcode;

import domain.ListNode;

class No237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

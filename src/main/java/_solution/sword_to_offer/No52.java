package _solution.sword_to_offer;

import domain.ListNode;

class No52 {
    /*
    输入两个链表，找出它们的第一个公共节点。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode i = headA;
        ListNode j = headB;
        int n = 0;
        while (i != j) {
            if (i == null) {
                n++;
                if (n == 2) {
                    return null;
                }
                i = headB;
            } else {
                i = i.next;
            }
            if (j == null) {
                j = headA;
            } else {
                j = j.next;
            }
        }
        return i;
    }
}

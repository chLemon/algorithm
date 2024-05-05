package _solution.sword_to_offer;

import domain.ListNode;

class No25 {
    /*
    输入两个递增排序的链表，
    合并这两个链表并使新链表中的节点仍然是递增排序的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        0 <= 链表长度 <= 1000
         */

        //让我想起了归并排序

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode l1head = l1;
        ListNode l2head = l2;

        ListNode head = null;
        //头结点：
        if (l1head.val < l2head.val) {
            head = l1head;
            l1head = l1head.next;
        } else {
            head = l2head;
            l2head = l2head.next;
        }

        //接下来的
        ListNode pre = head;
        ListNode curr = null;
        while (l1head != null && l2head != null) {

            if (l1head.val < l2head.val) {
                curr = l1head;
                l1head = l1head.next;
            } else {
                curr = l2head;
                l2head = l2head.next;
            }
            //min就是目前比较小的那个
            pre.next = curr;
            pre = curr;
        }
        //两个队列中有一个空了，另一个队列直接接到后面（pre）
        pre.next = (l1head == null) ? l2head : l1head;

        return head;
    }

    public void test() {
        /*
        输入：1->2->4, 1->3->4
        输出：1->1->2->3->4->4
         */

    }
}

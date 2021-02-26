package codinginterviews;

import codinginterviews.domain.ListNode;
import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class No22 {
    /*
        输入一个链表，
        输出该链表中倒数第k个节点。
        为了符合大多数人的习惯，
        本题从1开始计数，
        即链表的尾节点是倒数第1个节点。
        例如，一个链表有6个节点，
        从头节点开始，它们的值依次是
        1、2、3、4、5、6。
        这个链表的倒数第3个节点是值为4的节点。

        给定一个链表: 1->2->3->4->5, 和 k = 2.
        返回链表 4->5.
    */
    public ListNode getKthFromEnd(ListNode head, int k) {
        //异常处理



        ListNode pre = head;
        ListNode back = head.next;
        for (int i = 0; i < k-2; i++) {
             back=back.next;
        }
        if (k==1){
            back=head;
        }
        while (back.next!=null){
            pre=pre.next;
            back=back.next;
        }
        return pre;
    }
    @Test
    public void test(){
        for (int i = 0; i < 0; i++) {
            System.out.println("?");
        }
    }
}

package sword_to_offer;

import domain.ListNode;

class No18 {
    /*
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode deleteNode(ListNode head, int val) {
        //先看头结点是不是：
        if (head.val == val){
            //要删除头结点
            head = head.next;
            return head;
        }
        ListNode parent = head;
        ListNode now = head.next;
        while (now.val != val){
            parent = now;
            now = now.next;
        }
        //now现在就是当前匹配到的节点
            parent.next = now.next;
        return head;
    }

    public void test(){


    }



}

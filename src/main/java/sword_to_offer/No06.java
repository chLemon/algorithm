package sword_to_offer;

import domain.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。


 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No06 {
    public static int[] reversePrint(ListNode head) {
        /*
        直接用一个List？
         */
//        Stack<ListNode> stack = new Stack<>();
//        ListNode t = head;
//        while (t!=null){
//            stack.push(t);
//            t = t.next;
//        }
//        int size = stack.size();
//        int[] result = new int[size];
//        for (int i = 0; i < size; i++) {
//            result[i]=stack.pop().val;
//        }
//        return result;

        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode t = head;
        while (t != null) {
            list.add(head.val);
            t = t.next;
        }
        int length = list.size();
        int[] r = new int[length];
        for (int i = 0, j = length - 1; i < length && j > -1; i++, j--) {
            r[i] = list.get(j);
        }

        return r;

    }

    public static void main(String[] args) {
        /*
        输入：head = [1,3,2]
        输出：[2,3,1]
         */
        LinkedList l = new LinkedList();

    }
}

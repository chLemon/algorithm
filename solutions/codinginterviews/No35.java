package codinginterviews;

import codinginterviews.domain.No35.Node;

import java.util.HashMap;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
public class No35 {
    /*
    请实现 copyRandomList 函数，
    复制一个复杂链表。
    在复杂链表中，
    每个节点除了有一个 next 指针指向下一个节点，
    还有一个 random 指针指向链表中的任意节点或者 null。
     */
    public Node copyRandomList1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);

    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            Node curCopy = new Node(cur.val);
            curCopy.next = cur.next;
            cur.next = curCopy;
            cur = curCopy.next;
        }
        cur = head;
        while (cur != null) {
            Node curCopy = cur.next;
            if (cur.random == null) {
                curCopy.random = null;
            } else {
                curCopy.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        Node copyHead = head.next;
        Node copyNode = copyHead;
        while (head != null) {
            if (copyNode.next == null) {
                head.next = null;
            } else {
                head.next = copyNode.next;
                copyNode.next = copyNode.next.next;
            }
            head = head.next;
            copyNode = copyNode.next;

        }
        return copyHead;
    }

}

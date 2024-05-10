package _solution.leetcode;

import domain.ListNode;

import java.util.PriorityQueue;

public class No23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists)
            if (head != null)
                pq.offer(head);

        ListNode dummy = new ListNode(); // 哨兵节点，作为合并后链表头节点的前一个节点
        ListNode cur = dummy;
        while (!pq.isEmpty()) { // 循环直到堆为空
            ListNode node = pq.poll(); // 剩余节点中的最小节点
            if (node.next != null) // 下一个节点不为空
                pq.offer(node.next); // 下一个节点有可能是最小节点，入堆
            cur.next = node; // 合并到新链表中
            cur = cur.next; // 准备合并下一个节点
        }
        return dummy.next; // 哨兵节点的下一个节点就是新链表的头节点
    }
}

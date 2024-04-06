package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class No116 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            Node pre = null;
            for (int i = queue.size(); i > 0; i--) {
                Node cur = queue.poll();
                if (pre != null) pre.next = cur;
                pre = cur;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        // 假定当前层已经排好，根据当前层排下一层
        Node head = root;
        while (head != null) {
            Node node = head;
            while (node != null && node.left != null) {
                node.left.next = node.right;
                if (node.next != null) node.right.next = node.next.left;
                node = node.next;
            }
            head = head.left;
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}

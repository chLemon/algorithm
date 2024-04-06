package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class No117 {

    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2,
                        new Node(4), new Node(5)), new Node(3,
                null, new Node(7)));

        No117 no = new No117();
        no.connect2(root);
    }

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
        // 在当前层ok的情况下，处理下一层

        Node head = root;
        while (head != null) {
            Node nextHead = null;
            Node node = head;
            Node pre = null;
            while (node != null) {
                if (node.left != null) {
                    if (nextHead == null) {
                        nextHead = node.left;
                    }
                    if (pre == null) {
                        pre = node.left;
                    } else {
                        pre.next = node.left;
                        pre = node.left;
                    }
                }
                if (node.right != null) {
                    if (nextHead == null) {
                        nextHead = node.right;
                    }
                    if (pre == null) {
                        pre = node.right;
                    } else {
                        pre.next = node.right;
                        pre = node.right;
                    }
                }
                node = node.next;
            }
            head = nextHead;
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

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}

package _solution.programmercarl;

import java.util.LinkedList;
import java.util.Queue;

class No116 {

    // 还有一种空间复杂度O(1)的做法：假定当前层已经排好了，然后排下一层
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

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

    private static class Node {
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

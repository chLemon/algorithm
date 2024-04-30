package inf;

class No117 {

    public Node connect(Node root) {
        Node dummy = new Node();
        Node cur = root;
        while (cur != null) {   // 当前层
            dummy.next = null;  // 下一层的头结点
            Node nxt = dummy;
            while (cur != null) {   // 当前层不断往后
                if (cur.left != null) {
                    nxt.next = cur.left;
                    nxt = nxt.next;
                }
                if (cur.right != null) {
                    nxt.next = cur.right;
                    nxt = nxt.next;
                }
                cur = cur.next;
            }
            // 当前层遍历完，处理下一层
            cur = dummy.next;
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

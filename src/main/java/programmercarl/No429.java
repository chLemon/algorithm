package programmercarl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class No429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                Node cur = queue.poll();
                layer.add(cur.val);
                if (cur.children != null && !cur.children.isEmpty()) queue.addAll(cur.children);
            }
            res.add(layer);
        }
        return res;
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}

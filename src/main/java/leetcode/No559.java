package leetcode;

import java.util.Arrays;
import java.util.List;

public class No559 {


    public static void main(String[] args) {
        Node root = new Node(1, Arrays.asList(
                new Node(3,
                        Arrays.asList(new Node(5), new Node(6))),
                new Node(2),
                new Node(4)
        ));
        No559 no = new No559();
        int i = no.maxDepth(root);
        System.out.println(i);
    }

    public static int trya(String a) {
        return 0;
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int max = 0;
        for (Node node : root.children) {
            max = Math.max(maxDepth(node), max);
        }
        return max + 1;
    }

    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        return root.children.stream().mapToInt(this::maxDepth1).max().orElse(0) + 1;
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

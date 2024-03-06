package other;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    /**
     * 二叉树递归前序遍历
     */
    public List<Integer> preRecursive(Node root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 中左右
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }


}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
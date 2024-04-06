package leetcode;

import java.util.ArrayList;
import java.util.List;

class No144 {

    public static void main(String[] args) {
        No144 no = new No144();
        TreeNode root = new TreeNode(1,
                null, new TreeNode(2,
                new TreeNode(3), null));
        System.out.println(no.preorderTraversal(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        // 前序，中左右
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }

    /**
     * Definition for a binary tree node.
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


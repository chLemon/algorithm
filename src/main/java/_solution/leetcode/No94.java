package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

class No94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        // 中序遍历
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 左中右
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
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


 
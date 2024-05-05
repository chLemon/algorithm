package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

class No145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        // 后序遍历
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // 左右中
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

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

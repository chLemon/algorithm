package _solution.leetcode;

import domain.TreeNode;

class No114 {

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode rightest = findRightest(root.left);
                rightest.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    private TreeNode findRightest(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}

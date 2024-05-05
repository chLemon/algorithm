package _solution.leetcode;

class No617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode newRoot = new TreeNode(0);
        if (root1 != null) newRoot.val += root1.val;
        if (root2 != null) newRoot.val += root2.val;

        newRoot.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        newRoot.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return newRoot;
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode newRoot = new TreeNode(0);
        newRoot.val += root1.val;
        newRoot.val += root2.val;

        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
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

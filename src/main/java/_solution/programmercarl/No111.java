package _solution.programmercarl;

import domain.TreeNode;

class No111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepthHelper(root);
    }

    private int minDepthHelper(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.min(minDepthHelper(root.left), minDepthHelper(root.right));
    }
}

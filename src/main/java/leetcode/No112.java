package leetcode;

class No112 {


    /*
    给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

    叶子节点 是指没有子节点的节点。
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, root.val, targetSum) || hasPathSum(root.right, root.val, targetSum);
    }

    private boolean hasPathSum(TreeNode node, int lastSum, int targetSum) {
        if (node == null) {
            return false;
        }
        lastSum += node.val;
        if (node.left == null && node.right == null) {
            return lastSum == targetSum;
        }
        return hasPathSum(node.left, lastSum, targetSum) || hasPathSum(node.right, lastSum, targetSum);
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

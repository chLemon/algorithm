package _solution.sword_to_offer;

import domain.TreeNode;

class No55_2 {
    /*
    输入一棵二叉树的根节点，
    判断该树是不是平衡二叉树。
    如果某二叉树中任意节点的左右子树的深度相差不超过1，
    那么它就是一棵平衡二叉树。
     */
//    public boolean isBalanced(TreeNode root) {
//        return recur(root) != -1;
//    }
//
//    private int recur(TreeNode root) {
//        if (root == null) return 0;
//        int left = recur(root.left);
//        if(left == -1) return -1;
//        int right = recur(root.right);
//        if(right == -1) return -1;
//        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
//    }
    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        calDepthAndJudge(root);
        return result;
    }

    private int calDepthAndJudge(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = calDepthAndJudge(node.left);
        int rightDepth = calDepthAndJudge(node.right);
        if (leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1) {
            result = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

}

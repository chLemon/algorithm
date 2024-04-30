package inf;

class No98 {

    long INF = Long.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        // 左子树全部小于当前值，右子树全部大于当前值，子树也是BST
        return isValidBST(root, -INF, INF);
    }

    private boolean isValidBST(TreeNode root, long left, long right) {
        if (root == null) return true;
        if (root.val <= left || root.val >= right) return false;
        return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
    }

}

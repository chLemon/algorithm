package inf;

public class No110 {

    public boolean isBalanced(TreeNode root) {
        return isBalancedReturnHeight(root) != -1;
    }


    private int isBalancedReturnHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = isBalancedReturnHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = isBalancedReturnHeight(root.right);
        if (rightHeight == -1) return -1;
        return Math.abs(rightHeight - leftHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }
}

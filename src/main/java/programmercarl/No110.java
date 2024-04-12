package programmercarl;

public class No110 {

    // 左子树的深度 与 右子树的深度 差 <=1
    public boolean isBalanced(TreeNode root) {
        return isBalancedReturnHeight(root) >= 0;
    }

    private int isBalancedReturnHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = isBalancedReturnHeight(root.left);
        if (leftHeight < 0) return -1;
        int rightHeight = isBalancedReturnHeight(root.right);
        if (rightHeight < 0) return -1;
        if (Math.abs(rightHeight - leftHeight) > 1) return -1;
        return Math.max(rightHeight, leftHeight) + 1;
    }

}

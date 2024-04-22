package inf;

public class No101 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) return false;
        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }

}

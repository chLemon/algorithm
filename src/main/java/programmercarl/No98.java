package programmercarl;

class No98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null) {
            boolean leftRes = isValidBST(root.left) && root.val > findMax(root.left);
            if (!leftRes) return false;
        }
        if (root.right != null) return isValidBST(root.right) && root.val < findMin(root.right);
        return true;
    }

    private int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private int findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    /*
        // 利用上下界
    public boolean isValidBST(TreeNode root) {
        // 如果进入到左子树里，那么左子树的值要严格小于root.val才可以；如果进入到右子树里，则要严格大于root.val
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min) return false;
        if (root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
     */
}

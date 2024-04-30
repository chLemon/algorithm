package inf;

class No938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int x = root.val;
        if (x > high) {
            // 右子树不可能
            return rangeSumBST(root.left, low, high);
        }
        if (x < low) {
            // 左子树不可能
            return rangeSumBST(root.right, low, high);
        }
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);
        return left + right + x;
    }

}

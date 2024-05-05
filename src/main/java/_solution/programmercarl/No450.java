package _solution.programmercarl;

class No450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode rightLeftest = root.right;
            while (rightLeftest.left != null) {
                rightLeftest = rightLeftest.left;
            }
            rightLeftest.left = root.left;
            return root.right;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

}

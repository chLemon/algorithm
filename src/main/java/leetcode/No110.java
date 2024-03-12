package leetcode;

public class No110 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4,
                                        new TreeNode(5), null), null), null), null);
        No110 no = new No110();
        boolean balanced = no.isBalanced(root);
        System.out.println(balanced);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight == -1 || rightHeight == -1 ? false
                : Math.abs(leftHeight - rightHeight) <= 1;
    }

    // 如果不平衡，返回-1，否则返回树的高度
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        // 这里是-1可以提前返回
        int rightHeight = getHeight(root.right);
        return leftHeight != -1 && rightHeight != -1 && Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1 : -1;
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

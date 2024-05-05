package _solution.leetcode;

class No538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        // 右中左
        if (root == null) return root;
        convertBST(root.right);

        root.val += sum;
        sum = root.val;

        convertBST(root.left);
        return root;
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

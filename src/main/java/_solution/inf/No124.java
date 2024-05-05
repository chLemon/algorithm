package _solution.inf;

class No124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        max = Math.max(max, leftMax + rightMax + root.val);
        return Math.max(0, Math.max(leftMax, rightMax) + root.val);
    }

}

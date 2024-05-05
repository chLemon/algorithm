package _solution.inf;

class No112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        if (root.left == null) {
            return hasPathSum(root.right, targetSum - root.val);
        }
        if (root.right == null) {
            return hasPathSum(root.left, targetSum - root.val);
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == root.right) {
            return targetSum == 0;
        }
        return hasPathSum2(root.left, targetSum) || hasPathSum2(root.right, targetSum);
    }

}

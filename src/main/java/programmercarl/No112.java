package programmercarl;

public class No112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode root, int sum, int targetSum) {
        if (root == null) return false;
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }
        if (root.left != null) {
            boolean leftRes = dfs(root.left, sum, targetSum);
            if (leftRes) return true;
        }
        if (root.right != null) {
            return dfs(root.right, sum, targetSum);
        }
        return false;
    }

}

package inf;

public class No337 {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] leftRes = dfs(root.left);
        int[] rightRes = dfs(root.right);
        int rob = leftRes[1] + rightRes[1] + root.val;
        int noRob = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
        return new int[]{rob, noRob};
    }

}

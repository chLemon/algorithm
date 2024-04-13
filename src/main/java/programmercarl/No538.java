package programmercarl;

public class No538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        // 右中左
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);

        root.val += sum;
        sum = root.val;

        dfs(root.left);
    }

}

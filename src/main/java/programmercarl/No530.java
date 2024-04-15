package programmercarl;

class No530 {

    int min = 0x3f3f3f;
    int last = -1;

    // 中序遍历的最小差
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);

        // 中
        if (last != -1) {
            min = Math.min(root.val - last, min);
        }
        last = root.val;

        dfs(root.right);
    }

}

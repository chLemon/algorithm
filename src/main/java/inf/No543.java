package inf;

public class No543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        // 遍历每个节点，返回最长链的长度，长度是边的长度
        if (root == null) {
            return -1;
        }
        int leftLength = dfs(root.left);
        int rightLength = dfs(root.right);

        // 更新max
        max = Math.max(max, leftLength + rightLength + 2);

        return Math.max(leftLength, rightLength) + 1;
    }

}

package _solution.leetcode;

import _solution.inf.TreeNode;

class No687 {

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root, 0);

        return ans;
    }

    // 返回相同值的最长链长度
    private int dfs(TreeNode root, int pre) {
        if (root == null) return -1;

        int leftL = dfs(root.left, root.val) + 1;   // 以left为根，有值相同节点的边的数量
        int rightL = dfs(root.right, root.val) + 1;
        ans = Math.max(ans, leftL + rightL);

        return root.val != pre ? -1
                : Math.max(leftL, rightL);
    }

}

package _solution.inf;

import java.util.HashSet;
import java.util.Set;

class No1123 {

    Set<TreeNode> deepestLeaves = new HashSet<>();

    int maxDepth = -1;
    TreeNode ans;
    int maxDepth2 = -1;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // 先找到最深的一批节点
        dfs(root, 0);
        // 找到最近公共祖先
        return lca(root);
    }

    private TreeNode lca(TreeNode root) {
        if (root == null || deepestLeaves.contains(root)) {
            return root;
        }
        TreeNode left = lca(root.left);
        TreeNode right = lca(root.right);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > maxDepth) {
            if (!deepestLeaves.isEmpty()) deepestLeaves.clear();
            maxDepth = depth;
        }
        if (depth == maxDepth && root.left == null && root.right == null) {
            deepestLeaves.add(root);
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        // 先找到最深的一批节点
        dfs2(root, 0);
        // 找到最近公共祖先
        return ans;
    }

    private int dfs2(TreeNode node, int depth) {
        if (node == null) {
            maxDepth2 = Math.max(maxDepth2, depth);
            return depth;
        }

        int leftMaxDepth = dfs2(node.left, depth + 1);
        int rightMaxDepth = dfs2(node.right, depth + 1);
        if (leftMaxDepth == rightMaxDepth && leftMaxDepth == maxDepth2) {
            // 左右子树深度不一样时，答案一定在更深的那个里
            // 一样时，如果达到了目前的全局深度，则可能是答案
            // 这里比较的是子树的高度，所以 node == null 也要更新最大子树高度
            ans = node;
        }
        return Math.max(leftMaxDepth, rightMaxDepth);
    }

}

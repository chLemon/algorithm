package _solution.programmercarl;

import domain.TreeNode;
class No235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (root.val < p.val && root.val > q.val) return root;
        if (root.val > p.val && root.val < q.val) return root;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}

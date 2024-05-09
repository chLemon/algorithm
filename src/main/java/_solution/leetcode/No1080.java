package _solution.leetcode;

import domain.TreeNode;

class No1080 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean b = sufficientSubset(root, limit, 0);
        return b ? root : null;
    }

    private boolean sufficientSubset(TreeNode root, int limit, int sum) {
        // root节点是否应该被保留为非null值
        if (root == null) return false;
        sum += root.val;
        if (root.left == null && root.right == null) {
            // 叶子节点
            return sum >= limit;
        }

        boolean leftRes = sufficientSubset(root.left, limit, sum);
        if (!leftRes) root.left = null;
        boolean rightRes = sufficientSubset(root.right, limit, sum);
        if (!rightRes) root.right = null;
        return leftRes || rightRes;
    }

}

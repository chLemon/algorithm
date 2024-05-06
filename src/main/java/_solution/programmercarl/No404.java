package _solution.programmercarl;

import domain.TreeNode;

class No404 {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                // 左孩子是左叶子
                sum = root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }

}

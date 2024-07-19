package _solution.leetcode;

import domain.TreeNode;

public class No230 {

    int k = 0;
    int res = -1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));

        System.out.println(new No230().kthSmallest(root, 1));
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return res;
    }


    private void inorder(TreeNode root) {
        if (root == null || k < 0) return;

        inorder(root.left);
        // visit
        k--;
        if (k == 0) {
            res = root.val;
            return;
        }

        inorder(root.right);
    }
}

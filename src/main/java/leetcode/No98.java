package leetcode;

import java.util.ArrayList;
import java.util.List;

class No98 {

    // 利用上下界
    public boolean isValidBST(TreeNode root) {
        // 如果进入到左子树里，那么左子树的值要严格小于root.val才可以；如果进入到右子树里，则要严格大于root.val
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min) return false;
        if (root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    // 中序遍历严格递增版本
    public boolean isValidBST2(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        inorder(root, inorder);

        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i) >= inorder.get(i + 1)) return false;
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;

        // 左中右
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        if (root.left != null && getMax(root.left) >= root.val) {
            return false;
        }
        if (root.right != null && getMin(root.right) <= root.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    private int getMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    private int getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

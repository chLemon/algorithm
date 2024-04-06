package leetcode;

class No669 {


    public TreeNode trimBST(TreeNode root, int low, int high) {
        while (root != null && (root.val < low || root.val > high)) {
            while (root != null && root.val < low) {
                root = root.right;
            }
            while (root != null && root.val > high) {
                root = root.left;
            }
        }
        if (root == null) {
            return null;
        }
        // root现在是符合题意的根，则root.left<=high，root.right>=low
        // 所以需要剔除掉 root.left < low 的部分
        TreeNode leftParent = root;
        while (leftParent.left != null) {
            while (leftParent.left != null && leftParent.left.val < low) {
                leftParent.left = leftParent.left.right;
            }
            if (leftParent.left != null) {
                leftParent = leftParent.left;
            }
        }

        TreeNode rightParent = root;
        while (rightParent.right != null) {
            while (rightParent.right != null && rightParent.right.val > high) {
                rightParent.right = rightParent.right.left;
            }
            if (rightParent.right != null) {
                rightParent = rightParent.right;
            }
        }
        return root;
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

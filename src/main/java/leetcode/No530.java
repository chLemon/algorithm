package leetcode;

class No530 {


    int res = Integer.MAX_VALUE;
    TreeNode pre = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(7));
        No530 no = new No530();
        System.out.println(no.getMinimumDifference(root));
    }

    public int getMinimumDifference(TreeNode root) {
        // 遍历到的上一个节点
        TreeNode pre = null;
        // 中序遍历
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        // 中
        if (pre != null) {
            res = Math.min(res, Math.abs(pre.val - root.val));
        }
        pre = root;

        inorder(root.right);
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

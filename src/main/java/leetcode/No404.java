package leetcode;

class No404 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        No404 no = new No404();
        System.out.println(no.sumOfLeftLeaves(root));
    }

    /*
    给定二叉树的根节点 root ，返回所有左叶子之和。
    
    示例 1：
    输入: root = [3,9,20,null,null,15,7] 
    输出: 24 
    解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
    
    示例 2:
    输入: root = [1]
    输出: 0
    
    提示:
    节点数在 [1, 1000] 范围内
    -1000 <= Node.val <= 1000

     */

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
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

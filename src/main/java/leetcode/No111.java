package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class No111 {


    /**
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     * <p>
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9), new TreeNode(20,
                new TreeNode(15), new TreeNode(7)));

        TreeNode root2 = new TreeNode(2,
                null, new TreeNode(3,
                null, new TreeNode(4,
                null, new TreeNode(5,
                null, new TreeNode(6)))));

        No111 no = new No111();
        int i = no.minDepth(root);
        System.out.println(i);
        int i2 = no.minDepth(root2);
        System.out.println(i2);
    }

    public int minDepth2(TreeNode root) {
        // 层次遍历方法
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return depth;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) return 1;
        return Math.min(helper(root.left), helper(root.right)) + 1;
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

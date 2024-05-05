package _solution.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class No222 {

    /**
     * 思路1：二分法
     */
    public int countNodes1(TreeNode root) {
        return 0;
    }

    /**
     * 思路2：完全二叉树，满数的节点数是2^深度 - 1。非满树可以递归子树，直到是满树
     */
    public int countNodes2(TreeNode root) {
        int height = isFullTree(root);
        if (height >= 0) {
            return height == 0 ? 0
                    : (2 << (height - 1)) - 1;     // Math.pow(2, height) = 2 << height - 1
        }
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }

    // return 高度，最长路径的节点数
    private int isFullTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = 1;
        TreeNode left = root.left;
        while (left != null) {
            leftCount++;
            left = left.left;
        }
        int rightCount = 1;
        TreeNode right = root.right;
        while (right != null) {
            rightCount++;
            right = right.right;
        }
        return leftCount == rightCount ? leftCount : -1;
    }

    /**
     * 思路3：层次遍历计数
     */
    public int countNodes3(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            sum++;
            TreeNode poll = queue.poll();
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }
        return sum;
    }

    /**
     * 思路4：dfs遍历计数
     */
    public int countNode4(TreeNode root) {
        if (root == null) return 0;
        return countNode4(root.left) + countNode4(root.right) + 1;
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

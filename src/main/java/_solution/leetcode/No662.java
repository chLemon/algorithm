package _solution.leetcode;

import domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class No662 {

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Long> indexQueue = new LinkedList<>();
        queue.offer(root);
        indexQueue.offer(1L);
        while (!queue.isEmpty()) {
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                Long index = indexQueue.poll();
                min = Math.min(min, index);
                max = Math.max(max, index);
                if (node.left != null) {
                    queue.offer(node.left);
                    indexQueue.offer(index * 2 - 1);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    indexQueue.offer(index * 2);
                }
            }
            maxWidth = (int) Math.max(maxWidth, max - min + 1);
        }
        return maxWidth;
    }
}

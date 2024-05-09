package _solution.leetcode;

import domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class No2641 {

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curSum = root.val;   // 每一层的和
        while (!queue.isEmpty()) {
            int nextSum = 0;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                node.val = curSum - node.val;
                // 将node的左右儿子改为他们的和，并计算下一层和
                int childrenSum = 0;
                if (node.left != null) {
                    childrenSum += node.left.val;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    childrenSum += node.right.val;
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    node.left.val = childrenSum;
                }
                if (node.right != null) {
                    node.right.val = childrenSum;
                }
                nextSum += childrenSum;
            }
            curSum = nextSum;
        }
        return root;
    }

}
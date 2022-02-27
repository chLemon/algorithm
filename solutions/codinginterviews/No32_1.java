package codinginterviews;

import codinginterviews.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No32_1 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public int[] levelOrder(TreeNode root) {
        /*
        从上到下打印出二叉树的每个节点，
        同一层的节点按照从左到右的顺序打印。
         */
        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        int[] result = new int[list.size()];
        int j = 0;
        for (Integer num : list) {

            result[j] = num;
            j++;
        }

        return result;

    }
}

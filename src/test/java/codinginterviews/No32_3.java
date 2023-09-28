package codinginterviews;

import codinginterviews.domain.TreeNode;

import java.util.*;

public class No32_3 {
    /*
    请实现一个函数按照之字形顺序打印二叉树，
    即第一行按照从左到右的顺序打印，
    第二层按照从右到左的顺序打印，第
    三行再按照从左到右的顺序打印，
    其他行以此类推。
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        boolean odd = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List result = new ArrayList<>();
        while (!queue.isEmpty()) {
            LinkedList<Integer> each = new LinkedList<>();

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (odd) {
                    each.addLast(node.val);
                } else {
                    each.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            odd = !odd;
            result.add(each);
        }
        return result;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<List<Integer>> list = levelOrder(root);
    }
}

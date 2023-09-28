package solutions.codinginterviews;

import codinginterviews.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class No37 {
    /*
    请实现两个函数，分别用来序列化和反序列化二叉树。
     */
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String nodes = data.substring(1, data.length() - 1);
        String[] nodeArr = nodes.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.valueOf(nodeArr[0]));
        int i = 1;
        queue.offer(head);
        while (i < nodeArr.length) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (nodeArr[i].equals("null")) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.valueOf(nodeArr[i]));
                }
                queue.offer(node.left);
                i++;
                if (nodeArr[i].equals("null")) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.valueOf(nodeArr[i]));
                }
                queue.offer(node.right);
                i++;
            }
        }
        return head;
    }

    // Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.left.left = new TreeNode(4);
//        root.left.left.left.left = new TreeNode(5);
        String s = serialize(root);
        System.out.println(s);
        TreeNode deserialize = deserialize(s);
        System.out.println(serialize(deserialize));
    }
}

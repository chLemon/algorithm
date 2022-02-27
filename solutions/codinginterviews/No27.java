package codinginterviews;

import codinginterviews.domain.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class No27 {
    /*
    请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     */
    public TreeNode mirrorTree(TreeNode root) {
//层次遍历，把所有节点的left和right都换一下
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //访问
            System.out.println(node.val);
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

        }
        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        mirrorTree(root);
    }

}

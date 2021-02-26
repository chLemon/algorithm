package codinginterviews;

import codinginterviews.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No32_2 {
    /*
    从上到下按层打印二叉树，
    同一层的节点按从左到右的顺序打印，
    每一层打印到一行。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<List<Integer>> result = new ArrayList<>();
        while (!(queue.size() == 1 && queue.peek() == null)) {
            List<Integer> each = new ArrayList<>();
            while (true) {
                TreeNode node = queue.poll();
                if (node == null) {
                    queue.offer(null);
                    break;
                }
                each.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(each);

        }
        return result;
    }
}

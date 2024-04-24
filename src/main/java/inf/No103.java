package inf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean seq = true;
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> each = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (seq) {
                    each.addLast(node.val);
                } else {
                    each.addFirst(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            seq = !seq;
            res.add(each);
        }
        return res;
    }

}

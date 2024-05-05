package _solution.programmercarl;

import java.util.ArrayDeque;
import java.util.Deque;

class No513 {

    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode left = root;

        while (!queue.isEmpty()) {
            left = queue.peek();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return left.val;
    }

}

package _solution.programmercarl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class No94_iteration {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode NULL = new TreeNode();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != NULL) {
                // 当前节点非NULL标记，处理树的访问关系：
                // 右子树入栈
                if (cur.right != null) stack.push(cur.right);
                // 中间节点入栈
                stack.push(cur);
                stack.push(NULL);   // 做个标记，表示该节点是中间节点，已经处理了左右子树入栈，但是没访问
                // 左子树入栈继续处理
                if (cur.left != null) stack.push(cur.left);
            } else {
                // 遇到了NULL标记，该访问节点的值了
                // 取出节点
                cur = stack.pop();
                // 访问该节点
                res.add(cur.val);
            }
        }
        return res;
    }

}

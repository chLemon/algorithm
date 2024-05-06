package _solution.programmercarl;

import domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class No145_iteration {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode NULL = new TreeNode();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != NULL) {
                // 不是标志位，处理子树关系
                // 左右中
                stack.push(cur);
                stack.push(NULL);
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            } else {
                // 是标志位
                cur = stack.pop();
                res.add(cur.val);
            }
        }
        return res;
    }

}

package codinginterviews;

import codinginterviews.domain.TreeNode;

import java.util.Stack;

public class TreeExercise {
    /*
    树的遍历练习
     */
    //递归
    public void preOrderTraverseRecursive(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderTraverseRecursive(root.left);
            preOrderTraverseRecursive(root.right);
        }
    }

    //迭代
    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                System.out.print(node.val + "->");
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                node = tem.right;
            }

        }
    }

    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                System.out.print(tem.val + "->");
                node = tem.right;
            }
        }
    }

    public void postOrder(TreeNode root) {
//左右根，根入栈，右入栈，左入栈
        TreeNode cur, pre = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) ||
                    (pre != null && pre == cur.right)) {
                System.out.print(cur.val + "->");
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        new TreeExercise().postOrder(root);
    }
}

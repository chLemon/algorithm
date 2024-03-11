package other;

import java.util.*;

public class BinaryTree {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1,
//                null, new TreeNode(2,
//                new TreeNode(3), null)); 
        TreeNode root = new TreeNode(3,
                new TreeNode(1), new TreeNode(2));
        BinaryTree no = new BinaryTree();
        List<Integer> res = no.postorder(root);
        System.out.println(res);
    }

    /**
     * 二叉树递归前序遍历
     */
    public List<Integer> preRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 中左右
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // 迭代版
    public List<Integer> preorder(TreeNode root) {
        // 中，左，右
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            visitAlongLeftChain(node, stack, res);
        }
        return res;
    }

    void visitAlongLeftChain(TreeNode x, Deque<TreeNode> stack, List<Integer> res) {
        while (x != null) {
            res.add(x.val);
            if (x.right != null) {
                stack.push(x.right);
            }
            x = x.left;
        }
    }


    public List<Integer> inorder(TreeNode root) {
        // 左，中，右
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            // 先找到最下方的节点，stack.peek()
            goAlongLeftChain(root, stack, res);
            // 左孩子为空，访问之
            root = stack.pop();
            res.add(root.val);
            // 处理其右子树
            root = root.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    private void goAlongLeftChain(TreeNode node, Deque<TreeNode> stack, List<Integer> res) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode node = null;

        while (!stack.isEmpty()) {
            if ((stack.peek().left != node && stack.peek().right != node) || node == null) {
                // 上一个刚刚访问过的节点是一个左节点，该访问右树
                gotoLHL(stack.pop(), stack);
            } else {
                // 上一个刚刚访问过的节点是一个右节点，该访问父亲（stack.peek()）
            }
            node = stack.pop();
            res.add(node.val);
        }
        return res;
    }

    private void gotoLHL(TreeNode node, Deque<TreeNode> stack) {
        // 当node不是叶子节点时，先左后右
        while (node.left != null || node.right != null) {
            if (node.left != null) {
                stack.push(node);
                if (node.right != null) stack.push(node.right);
                node = node.left;
            } else if (node.right != null) {
                stack.push(node);
                node = node.right;
            }
        }
        // node是叶子节点
        stack.push(node);
    }


    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}


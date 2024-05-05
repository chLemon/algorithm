package _solution.leetcode;

class No450 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        No450 no = new No450();
        no.deleteNode(root, 3);
    }

    /*
    给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null && cur.val != key) {
            pre = cur;
            if (cur.val < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        if (cur == null) return root;   // not found

        TreeNode node = findNewNode(cur);
        if (pre == null) {
            return node;
        }
        if (pre.left == cur) {
            pre.left = node;
        } else {
            pre.right = node;
        }
        return root;
    }

    private TreeNode findNewNode(TreeNode cur) {
        if (cur.left == null) {
            return cur.right;
        } else if (cur.right == null) {
            return cur.left;
        } else {
            TreeNode node = cur.left;
            while (node.right != null) {
                node = node.right;
            }
            node.right = cur.right;
            return cur.left;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

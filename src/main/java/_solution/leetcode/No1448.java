package _solution.leetcode;

import domain.TreeNode;

class No1448 {

    int INF = 0x3f3f3f;

    public static void main(String[] args) {
        System.out.println(new No1448().goodNodes(new TreeNode(2, null, new TreeNode(4, new TreeNode(10), new TreeNode(8, new TreeNode(4), null)))));
    }

    public int goodNodes(TreeNode root) {
        return goodNodes(root, -INF);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val >= max) {
            count++;
            max = root.val;
        }
        return goodNodes(root.left, max) + goodNodes(root.right, max) + count;
    }

}

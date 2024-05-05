package _solution.programmercarl;

class No222 {

    public static void main(String[] args) {
        No222 no = new No222();
        no.countNodes(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null)));
    }

    public int countNodes(TreeNode root) {
        return countTree(root);
    }

    private int countTree(TreeNode root) {
        if (root == null) return 0;
        int leftCount = 0;
        int rightCount = 0;
        TreeNode move = root;
        while (move.left != null) {
            move = move.left;
            leftCount++;
        }
        move = root;
        while (move.right != null) {
            move = move.right;
            rightCount++;
        }
        return leftCount == rightCount ? (1 << (leftCount + 1)) - 1 : 1 + countTree(root.left) + countTree(root.right);
    }

}

package inf;

class No129 {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        findNumber(root, 0);
        return sum;
    }

    private void findNumber(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        findNumber(root.left, num);
        findNumber(root.right, num);
    }

}

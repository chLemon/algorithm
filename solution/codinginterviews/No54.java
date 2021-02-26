package codinginterviews;

import codinginterviews.domain.TreeNode;

public class No54 {
    int k;
    int count;
    int result;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return result;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.right);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inOrder(root.left);
    }
}

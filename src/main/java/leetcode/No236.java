package leetcode;

public class No236 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode q = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(3,
                p,
                q);
        No236 no = new No236();
        System.out.println(no.lowestCommonAncestor(root, p, q));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        // find in left
        if (leftRes != null && leftRes != p && leftRes != q) {
            return leftRes;
        }
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
        // find in right
        if (rightRes != null && rightRes != p && rightRes != q) {
            return rightRes;
        }
        if (leftRes != null && rightRes != null) return root;
        if (leftRes == null) return root == p || root == q ? root : rightRes;
        return root == p || root == q ? root : leftRes;
    }

    /*
    当 leftleftleft 为空 ，rightrightright 不为空 ：p,qp,qp,q 都不在 rootrootroot 的左子树中，直接返回 rightrightright 。具体可分为两种情况：
    p,qp,qp,q 其中一个在 rootrootroot 的 右子树 中，此时 rightrightright 指向 ppp（假设为 ppp ）；
    p,qp,qp,q 两节点都在 rootrootroot 的 右子树 中，此时的 rightrightright 指向 最近公共祖先节点 ；
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

}

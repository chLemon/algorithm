package codinginterviews;

import codinginterviews.domain.TreeNode;

public class No28 {
    
    /*
    请实现一个函数，用来判断一棵二叉树是不是对称的。
    如果一棵二叉树和它的镜像一样，那么它是对称的。

    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     */

    public boolean isSymmetric(TreeNode root) {
//大佬的思路：对称的2个节点满足3个条件，
// 自己的val相同，
// 自己的左孩子和对称节点的右孩子相同，
// 自己的右孩子和对称点的左孩子相同
        if (root == null) {
            return true;
        }
        return isCorrespondTree(root.left, root.right);

    }

    public boolean isCorrespondTree(TreeNode A, TreeNode B) {

        if ((A == null && B != null) || (A != null && B == null)) {
            return false;
        }
        if (A == null && B == null) {
            return true;
        }
        if (A.val != B.val) {
            return false;
        }
        return isCorrespondTree(A.left, B.right) && isCorrespondTree(A.right, B.left);
    }
}

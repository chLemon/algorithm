package _solution.sword_to_offer;

import domain.TreeNode;

class No68_1 {
    /*
    给定一个二叉搜索树,
    找到该树中两个指定节点的最近公共祖先。

    百度百科中最近公共祖先的定义为：
    “对于有根树 T 的两个结点 p、q，
    最近公共祖先表示为一个结点 x，
    满足 x 是 p、q 的祖先
    且 x 的深度尽可能大
    （一个节点也可以是它自己的祖先）。”

    例如，给定如下二叉搜索树: 
    root = [6,2,8,0,4,7,9,null,null,3,5]
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val) {
            return p;//root == p
        } else if (root.val == q.val) {
            return q;//root == q
        }
        if ((p.val - root.val > 0 && root.val - q.val > 0) || (p.val - root.val < 0 && root.val - q.val < 0)) {
            return root;
        } else if (p.val - root.val > 0) {
            //在右侧
            return lowestCommonAncestor(root.right, p, q);
        } else {
            //左侧
            return lowestCommonAncestor(root.left, p, q);
        }
    }

}

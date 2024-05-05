package sword_to_offer;

import domain.TreeNode;

class No55_1 {
    /*
    输入一棵二叉树的根节点，
    求该树的深度。
    从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
    最长路径的长度为树的深度。
     */
    int maxDepth;
    public int maxDepth(TreeNode root) {
        preOrder(root,0);
        return maxDepth;

        /*
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
         */
    }
    public void preOrder(TreeNode node,int depth){
        if (node == null){
            return;
        }
        depth++;
        if (depth>this.maxDepth){
            this.maxDepth=depth;
        }
        preOrder(node.left,depth);
        preOrder(node.right,depth);
    }
}

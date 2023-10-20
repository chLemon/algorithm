package codinginterviews;

import codinginterviews.domain.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class No26 {

    /*
    输入两棵二叉树A和B，判断B是不是A的子结构。

    (约定空树不是任意一个树的子结构)

    B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     */
    
    public  boolean isSubStructure(TreeNode A,TreeNode B){
        if (A == null || B == null){return false;}
        return recur(A,B)|| isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
    boolean recur(TreeNode A, TreeNode B){
        if (B==null){return true;}
        if (A==null||A.val!=B.val){return false;}
        return recur(A.left,B.left) && recur(A.right,B.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        new TreeExercise().preOrder(root);

    }
}

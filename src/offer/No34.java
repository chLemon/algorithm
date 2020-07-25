package offer;

import offer.domain.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No34 {
    /*
    输入一棵二叉树和一个整数，
    打印出二叉树中节点值的和为输入整数的所有路径。
    从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     */
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        int pathSum = 0;
        preOrder(root, pathSum);
        return result;
    }

    public void preOrder(TreeNode node, int pathSum) {
        pathSum += node.val;
        if (pathSum > sum) {

        }
        if (pathSum == sum) {

        }
        if (node.left != null) {
            preOrder(node.left, pathSum);
        }
        if (node.right != null) {
            preOrder(node.right, pathSum);
        }
        return;
    }

}

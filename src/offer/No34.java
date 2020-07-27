package offer;

import offer.domain.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No34 {
    /*
    输入一棵二叉树和一个整数，
    打印出二叉树中节点值的和为输入整数的所有路径。
    从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     */
//    LinkedList<List<Integer>> res = new LinkedList<>();
//    LinkedList<Integer> path = new LinkedList<>();
//
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        recur(root, sum);
//        return res;
//    }
//
//    void recur(TreeNode root, int tar) {
//        if (root == null) return;
//        path.add(root.val);
//        tar -= root.val;
//        if (tar == 0 && root.left == null && root.right == null)
//            res.add(new LinkedList(path));
//        recur(root.left, tar);
//        recur(root.right, tar);
//        path.removeLast();
//    }
    //大佬太牛逼了！

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        preOrder(root, sum);
        return result;
    }

    public void preOrder(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            result.add(new LinkedList(path));
        }
        if (node.left != null) {
            preOrder(node.left, target);
        }
        if (node.right != null) {
            preOrder(node.right, target);
        }
        path.removeLast();

    }

}

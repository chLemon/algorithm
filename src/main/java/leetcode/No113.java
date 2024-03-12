package leetcode;

import java.util.ArrayList;
import java.util.List;

public class No113 {


    /*
    给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

    叶子节点 是指没有子节点的节点。
    
    输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
    输出：[[5,4,11,2],[5,8,4,5]]
    
    输入：root = [1,2,3], targetSum = 5
    输出：[]
    
    输入：root = [1,2], targetSum = 0
    输出：[]
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int sum = root.val;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                res.add(path);
            }
            return res;
        }
        findPath(root.left, path, sum, targetSum, res);
        findPath(root.right, path, sum, targetSum, res);

        return res;
    }

    private void findPath(TreeNode root, List<Integer> path, int sum, int targetSum, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            // 到叶子节点了
            if (sum == targetSum) {
                res.add(new ArrayList<>(path));
            }
        } else {
            findPath(root.left, path, sum, targetSum, res);
            findPath(root.right, path, sum, targetSum, res);
        }
        // 回退
        path.remove(path.size() - 1);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}

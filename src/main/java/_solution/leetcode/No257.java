package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

class No257 {
    public static void main(String[] args) {
        No257 no = new No257();

        TreeNode root1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        System.out.println(no.binaryTreePaths(root1));

        TreeNode root2 = new TreeNode(1);
        System.out.println(no.binaryTreePaths(root2));
    }

    /*
    给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

    叶子节点 是指没有子节点的节点。
    
     
    示例 1：
    输入：root = [1,2,3,null,5]
    输出：["1->2->5","1->3"]
    
    示例 2：
    输入：root = [1]
    输出：["1"]
     */

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        findPath(root, path, res);
        return res;
    }

    private void findPath(TreeNode node, List<String> path, List<String> res) {
        if (node == null) {
            return;
        }
        path.add(node.val + "");

        if (node.left == null && node.right == null) {
            // 叶子节点
            if (path.size() != 1) {
                res.add(String.join("->", path));
            } else {
                res.add(path.get(0));
            }
        } else {
            // 非叶子节点，继续深入寻找
            findPath(node.left, path, res);
            findPath(node.right, path, res);
        }
        // 退出前删掉当前节点
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

package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class No501 {

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

    /*
    给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。

    如果树中有不止一个众数，可以按 任意顺序 返回。

    假定 BST 满足如下定义：

    结点左子树中所含节点的值 小于等于 当前节点的值
    结点右子树中所含节点的值 大于等于 当前节点的值
    左子树和右子树都是二叉搜索树
     */
    public int[] findMode2(TreeNode root) {
        // 中序遍历
        List<Integer> inorder = new ArrayList<>();

        inorder(root, inorder);

        return findMax(inorder);
    }

    int countMax = Integer.MIN_VALUE;
    TreeNode preNode = null;
    int count = 0;

    public int[] findMode(TreeNode root) {
        // 中序遍历的同时处理最值问题
        List<Integer> res = new ArrayList<>();

        inorder2(root, res);

        return res.stream().mapToInt(a -> a).toArray();
    }

    private void inorder2(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorder2(root.left, res);

        // 处理逻辑
        if (preNode == null || preNode.val == root.val) {
            count++;
        } else {
            count = 1;
        }
        if (count > countMax) {
            res.clear();
            res.add(root.val);
            countMax = count;
        } else if (count == countMax) {
            res.add(root.val);
        }
        preNode = root;

        inorder2(root.right, res);
    }

    private int[] findMax(List<Integer> inorder) {
        List<Integer> res = new ArrayList<>();
        // 遍历
        int countMax = Integer.MIN_VALUE;
        int i = 0;
        while (i < inorder.size()) {
            int count = 0;
            while (i + 1 < inorder.size() && Objects.equals(inorder.get(i + 1), inorder.get(i))) {
                i++;
                count++;
            }
            if (count == countMax) {
                // 当前数也是最大值之一
                res.add(inorder.get(i));
            } else if (count > countMax) {
                // 当前数才是最大数
                res.clear();
                res.add(inorder.get(i));
                countMax = count;
            }
            i++;
        }
        return res.stream().mapToInt(a -> a).toArray();
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

}

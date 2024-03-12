package leetcode;

import java.util.Arrays;

public class No106 {


    public static void main(String[] args) {
        No106 no = new No106();
        no.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    /*
    给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。

    示例 1:
    输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    输出：[3,9,20,null,null,15,7]
    
    示例 2:
    输入：inorder = [-1], postorder = [-1]
    输出：[-1]
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }

        // postorder可以确定root, 根据root可以找到左子树和右子树，然后分别重构
        int rootVal = postorder[postorder.length - 1];
        // 左子树，右子树
        int[] leftInorder = null, rightInorder = null;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                leftInorder = Arrays.copyOfRange(inorder, 0, i);
                rightInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                break;
            }
        }
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftInorder.length, postorder.length - 1);

        return new TreeNode(rootVal, buildTree(leftInorder, leftPostorder), buildTree(rightInorder, rightPostorder));
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        int inorderLength = inorderStart - inorderEnd;
        if (inorderLength == 0) {
            return null;
        }
        if (inorderLength == 1) {
            return new TreeNode(inorder[inorderStart]);
        }
        int rootVal = postorder[postorderEnd - 1];
        // 左子树
        // 这里可以用hashmap加速
        int leftInorderEnd = -1;
        for (int i = inorderStart; i < inorderEnd; i++) {
            if (rootVal == inorder[i]) {
                leftInorderEnd = i;
                break;
            }
        }
        /*
        左子树中序 inorderStart , leftInorderEnd
        右子树中序 leftInorderEnd + 1 , inorderEnd 
         */
        return new TreeNode(postorder[postorderEnd - 1],
                buildTreeHelper(inorder, inorderStart, leftInorderEnd, postorder, postorderStart, postorderStart + leftInorderEnd - inorderStart),
                buildTreeHelper(inorder, leftInorderEnd + 1, inorderEnd, postorder, postorderStart + leftInorderEnd - inorderStart, postorderEnd - 1));
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

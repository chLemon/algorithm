package _solution.leetcode;

import java.util.HashMap;
import java.util.Map;

class No105 {

    public static void main(String[] args) {
        No105 no = new No105();
        System.out.println(no.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 每次都要在中序里找到root
        Map<Integer, Integer> val2Index = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            val2Index.put(inorder[i], i);
        }

        return buildTree(preorder, val2Index, 0, preorder.length, 0);
    }

    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> val2Index, int preorderStart, int preorderEnd, int inorderStart) {
        int length = preorderEnd - preorderStart;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return new TreeNode(preorder[preorderStart]);
        }

        int rootVal = preorder[preorderStart];
        Integer inorderRootIndex = val2Index.get(rootVal);
        int newLeftLength = inorderRootIndex - inorderStart;
        return new TreeNode(rootVal,
                buildTree(preorder, val2Index, preorderStart + 1, preorderStart + 1 + newLeftLength, inorderStart),
                buildTree(preorder, val2Index, preorderStart + 1 + newLeftLength, preorderEnd, inorderRootIndex + 1));
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

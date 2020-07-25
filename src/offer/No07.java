package offer;

import offer.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class No07 {
    /*
    输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     */
    /*
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length, indexMap);
    }

    public TreeNode buildTree(int[] preorder, int plo, int phi, int[] inorder, int ilo, int ihi, Map<Integer, Integer> indexMap) {
        if (plo == phi - 1) {
            return new TreeNode(preorder[plo]);
        }
        if (plo > phi - 1) {
            return null;
        }
        int rootVal = preorder[plo];
        TreeNode root = new TreeNode(rootVal);
        int rIndex = indexMap.get(rootVal);
        root.left = buildTree(preorder, plo + 1, plo + rIndex - ilo + 1, inorder, ilo, rIndex, indexMap);
        root.right = buildTree(preorder, plo + rIndex - ilo + 1, phi, inorder, rIndex + 1, ihi, indexMap);
        return root;
    }

    /*
    大佬的答案
     */
    int preindex = 0;
    int inindex = 0;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {

        return buildtree(preorder, inorder, null);

    }

    public TreeNode buildtree(int[] preorder, int[] inorder, TreeNode finish) {
/*
这种方法本质上是迭代的那种思想，只不过递归先天有栈的属性，不需要用辅助栈了
 */
        if (preindex == preorder.length || (finish != null && inorder[inindex] == finish.val)) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preindex++]); //第一次创建的时候就是以第一个根节点创建的
        //左子树
        root.left = buildtree(preorder, inorder, root);
        inindex++;
        //右子树
        root.right = buildtree(preorder, inorder, finish);

        return root;

    }

    public static void main(String[] args) {
/*
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
 */
        No07 n = new No07();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = n.buildTree(preorder, inorder);
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);

    }

}

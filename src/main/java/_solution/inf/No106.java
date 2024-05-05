package _solution.inf;

import java.util.HashMap;
import java.util.Map;

class No106 {

    Map<Integer, Integer> inorderMap = new HashMap<>();

    public static void main(String[] args) {
        new No106().buildTree(new int[]{9, 3, 15, 20, 7},
                new int[]{9, 15, 7, 20, 3});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 中：左 中 右
        // 后：左 右 中
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(postorder, 0, inorder.length, 0, postorder.length);
    }

    private TreeNode buildTree(int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft >= inRight) return null;
        int x = postorder[postRight - 1];
        Integer rootIndex = inorderMap.get(x);

        int leftSize = rootIndex - inLeft;

        return new TreeNode(x,
                buildTree(postorder, inLeft, inLeft + leftSize, postLeft, postLeft + leftSize),
                buildTree(postorder, inLeft + leftSize + 1, inRight, postLeft + leftSize, postRight - 1));
    }

}

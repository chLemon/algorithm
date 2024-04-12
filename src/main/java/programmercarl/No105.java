package programmercarl;

import java.util.HashMap;
import java.util.Map;

class No105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 中 左右
        // 左中右
        // 由于频繁需要寻找inorder中某个值的下标，提前处理map
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndexMap);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderIndexMap) {
        if (preStart > preEnd) return null;
        if (preStart == preEnd) return new TreeNode(preorder[preStart]);


        int rootVal = preorder[preStart];
        int rootInIndex = inorderIndexMap.get(rootVal);
        int leftPreStart = preStart + 1,
                leftInStart = inStart,
                leftInEnd = rootInIndex - 1,
                leftPreEnd = leftInEnd - leftInStart + leftPreStart,
                rightPreStart = leftPreEnd + 1,
                rightPreEnd = preEnd,
                rightInStart = rootInIndex + 1,
                rightInEnd = inEnd;
        return new TreeNode(rootVal,
                buildTree(preorder, leftPreStart, leftPreEnd, inorder, leftInStart, leftInEnd, inorderIndexMap),
                buildTree(preorder, rightPreStart, rightPreEnd, inorder, rightInStart, rightInEnd, inorderIndexMap));
    }

}

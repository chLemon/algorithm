package inf;

import java.util.HashMap;
import java.util.Map;

public class No889 {

    Map<Integer, Integer> postorderMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // 题目保证所有值都不相同
        // 中 左 右
        // 左 右 中
        for (int i = 0; i < postorder.length; i++) {
            postorderMap.put(postorder[i], i);
        }

        return constructFromPrePost(preorder, 0, preorder.length, postorder, 0, postorder.length);
    }

    private TreeNode constructFromPrePost(int[] preorder, int preL, int preR, int[] postorder, int postL, int postR) {
        if (preL >= preR) return null;
        if (preR - preL == 1) return new TreeNode(preorder[preL]);

        int leftRootValue = preorder[preL + 1];
        int leftSize = postorderMap.get(leftRootValue) + 1 - postL;
        return new TreeNode(preorder[preL],
                constructFromPrePost(preorder, preL + 1, preL + 1 + leftSize,
                        postorder, postL, postL + leftSize),
                constructFromPrePost(preorder, preL + 1 + leftSize, preR,
                        postorder, postL + leftSize, postR - 1));
    }

}

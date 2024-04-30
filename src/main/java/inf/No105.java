package inf;

class No105 {

    public static void main(String[] args) {
        new No105().buildTree(new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前：中 左 右
        // 中：左 中 右
        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    // [ )
    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft >= preRight) {
            return null;
        }
        int root = preorder[preLeft];
        int rootIndex;
        for (rootIndex = inLeft; rootIndex < inRight; rootIndex++) {
            if (root == inorder[rootIndex]) {
                break;
            }
        }
        return new TreeNode(root,
                buildTree(preorder, inorder, preLeft + 1, preLeft + 1 + rootIndex - inLeft, inLeft, rootIndex),    // 左子树
                buildTree(preorder, inorder, preLeft + 1 + rootIndex - inLeft, preRight, rootIndex + 1, inRight));
    }

}

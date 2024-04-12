package programmercarl;

public class No106 {

    public static void main(String[] args) {
        No106 no = new No106();
        no.buildTree(new int[]{1, 2}, new int[]{2, 1});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder 左根右
        // postorder 左右根
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) return null;
        if (inStart == inEnd) return new TreeNode(inorder[inStart]);

        int rootVal = postorder[postEnd];
        int leftInStart, leftInEnd, rightInStart, rightInEnd, leftPostStart, leftPostEnd, rightPostStart, rightPostEnd;
        leftInStart = inStart;
        leftInEnd = inStart - 1;
        while (leftInEnd < inEnd) {
            if (inorder[leftInEnd + 1] == rootVal) break;
            leftInEnd++;
        }
        rightInStart = leftInEnd + 2;
        rightInEnd = inEnd;

        leftPostStart = postStart;
        leftPostEnd = leftInEnd - leftInStart + leftPostStart;
        rightPostStart = leftPostEnd + 1;
        rightPostEnd = postEnd - 1;

        return new TreeNode(rootVal,
                buildTree(inorder, leftInStart, leftInEnd, postorder, leftPostStart, leftPostEnd),
                buildTree(inorder, rightInStart, rightInEnd, postorder, rightPostStart, rightPostEnd));
    }

}

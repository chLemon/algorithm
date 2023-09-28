package solutions.codinginterviews;

import org.junit.Test;

public class No33 {
    /*
    输入一个整数数组，
    判断该数组是不是某二叉搜索树的后序遍历结果。
    如果是则返回 true，否则返回 false。
    假设输入的数组的任意两个数字都互不相同。
     */
    @Test
    public void test() {
/*
[4, 8, 6, 12, 16, 14, 10]
 */
        int[] ints = {4, 8, 6, 12, 16, 14, 10};
        verifyPostorder(ints);

    }

    public boolean verifyPostorder(int[] postorder) {
        // 0 1
        return verifyPostorder2(postorder, 0, postorder.length);

    }

    public boolean verifyPostorder2(int[] postorder, int start, int end) {
        // 0 1
        if (start >= end - 2) {
            return true;
        }

        int rootIndex = end - 1;
        int rightStartIndex = start;
        while (postorder[rightStartIndex] < postorder[rootIndex]) {
            rightStartIndex++;
        }
        //左子树天然满足
        int i = rightStartIndex;
        while (i < rootIndex) {
            if (postorder[i] < postorder[rootIndex]) {
                return false;
            }
            i++;
        }
        return verifyPostorder2(postorder, start, rightStartIndex) && verifyPostorder2(postorder, rightStartIndex, rootIndex);

    }
}

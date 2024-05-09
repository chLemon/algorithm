package _solution.leetcode;

import domain.TreeNode;

import java.util.Arrays;

class No1373 {

    int max = 0;
    int INF = 0x3f3f3f;

    public static void main(String[] args) {
        System.out.println(new No1373().maxSumBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
    }

    public int maxSumBST(TreeNode root) {
        postorder(root);
        return max;
    }

    // int[]: 0 sum 当不是二叉搜索树时为-0x3f3f3f，1 minValue，2 maxValue 
    private int[] postorder(TreeNode root) {
        if (root == null) {
            return new int[]{0, INF, -INF};
        }
        int[] leftRes = postorder(root.left);
        int[] rightRes = postorder(root.right);
        System.out.println(root.val + "  " + Arrays.toString(leftRes));
        System.out.println(root.val + "  " + Arrays.toString(rightRes));

        if (leftRes[0] == -INF || rightRes[0] == -INF) {
            return new int[]{-INF, 0, 0};
        }
        // 判断是否为二叉搜索树
        int x = root.val;
        if (x >= rightRes[1] || x <= leftRes[2]) {
            return new int[]{-INF, 0, 0};
        }
        // 二叉搜索树，求和返回
        int sum = x + leftRes[0] + rightRes[0];
        max = Math.max(max, sum);
        return new int[]{sum,
                Math.min(x, leftRes[1]), Math.max(x, rightRes[2])};
    }

}

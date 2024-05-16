package _solution.programmercarl;

import domain.TreeNode;

class No337 {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * @return 0 不偷，1 偷
     */
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] leftRes = dfs(node.left);
        int[] rightRes = dfs(node.right);
        return new int[]{
                Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]),
                node.val + leftRes[0] + rightRes[0]
        };
    }


}

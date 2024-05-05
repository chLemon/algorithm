package _solution.inf;

class No968 {

    public int minCameraCover(TreeNode root) {
        int[] res = dfs(root);
        return min(res[0], res[2]);
    }

    /**
     * @return 0 节点自己装摄像头，1 自己不装，被父亲监控，2 自己不装，被孩子监控
     */
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0x3f3f3f, 0, 0};
        }

        int[] leftRes = dfs(root.left);
        int[] rightRes = dfs(root.right);
        // 自己装，儿子随意
        int self = 1 + min(leftRes[0], leftRes[1], leftRes[2]) + min(rightRes[0], rightRes[1], rightRes[2]);
        // 自己被父亲监控，孩子可以0 2
        int parent = min(leftRes[0], leftRes[2]) + min(rightRes[0], rightRes[2]);
        // 自己被孩子监控，孩子至少有一个装
        int child = min(leftRes[0] + rightRes[0], leftRes[0] + rightRes[2], leftRes[2] + rightRes[0]);
        return new int[]{self, parent, child};
    }

    private int min(int... args) {
        int min = Integer.MAX_VALUE;
        for (int i : args) {
            min = Math.min(i, min);
        }
        return min;
    }

}

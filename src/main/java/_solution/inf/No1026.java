package _solution.inf;

class No1026 {

    int V = 0;

    public int maxAncestorDiff(TreeNode root) {
        int value = root.val;
        maxAncestorDiff(root.left, value, value);
        maxAncestorDiff(root.right, value, value);
        return V;
    }

    private void maxAncestorDiff(TreeNode root, int pathMin, int pathMax) {
        if (root == null) return;
        int value = root.val;
        int v1 = Math.abs(value - pathMin);
        int v2 = Math.abs(value - pathMax);
        V = Math.max(V, v1);
        V = Math.max(V, v2);
        pathMin = Math.min(pathMin, value);
        pathMax = Math.max(pathMax, value);
        maxAncestorDiff(root.left, pathMin, pathMax);
        maxAncestorDiff(root.right, pathMin, pathMax);
    }

}

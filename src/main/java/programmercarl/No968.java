package programmercarl;

public class No968 {

    int INF = 0x3f3f3f;

    public static void main(String[] args) {
        No968 no = new No968();
        no.minCameraCover(
                new TreeNode(0,
                        new TreeNode(0, new TreeNode(0,
                                new TreeNode(0, new TreeNode(0), null
                                ), null
                        ), new TreeNode(0)
                        ),
                        new TreeNode(0,
                                new TreeNode(0, null, new TreeNode(0)), null
                        ))
        );
    }

    // 装：自己监控自己      1
    // 不装：父亲监控自己    2
    // 不装：儿子监控自己    3
    public int minCameraCover(TreeNode root) {
        int[] res = dfs(root);  // root只能是1，3
        return Math.min(res[0], res[2]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{INF, 0, 0};
        if (root.left == null && root.right == null) {
            // 如果是子节点，只能是 1 2
            return new int[]{1, 0, INF};
        }
        int[] leftRes = dfs(root.left);
        int[] rightRes = dfs(root.right);

        // 自己装
        int res1 = Math.min(Math.min(leftRes[0], leftRes[1]), leftRes[2])
                + Math.min(Math.min(rightRes[0], rightRes[1]), rightRes[2])
                + 1;
        int res2 = Math.min(leftRes[0], leftRes[2])
                + Math.min(rightRes[0], rightRes[2]);
        // 被儿子监控，则 左1 + 右非2，右1 + 左非2，所有情况里的最小值
        // 左1 + 右1 ， 左1 + 右3 ，左3 + 右1
        int res3 = Math.min(
                Math.min(leftRes[0] + rightRes[0], leftRes[0] + rightRes[2]), leftRes[2] + rightRes[0]
        );
        return new int[]{res1, res2, res3};
    }

}

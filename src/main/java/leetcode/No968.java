package leetcode;

public class No968 {

    public static void main(String[] args) {
        No968 no = new No968();
        TreeNode root1 = new TreeNode(0, new TreeNode(0,
                new TreeNode(0,
                        new TreeNode(0, null, new TreeNode(0)), null), null), null);
        TreeNode root2 = new TreeNode(0, new TreeNode(0, new TreeNode(), new TreeNode()), null);
        int i = no.minCameraCover(root2);
        System.out.println(i);
    }

    public int minCameraCover(TreeNode root) {
        int[] res = helper(root);
        return Math.min(res[0], res[2]);
    }

    // return: 0 自己放，1 父亲放从而被监控，2 儿子放从而被监控
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0x3f3f3f, 0, 0};
        }
        int[] res = new int[3];

        int[] leftRes = helper(root.left);
        int[] rightRes = helper(root.right);

        res[0] = min(leftRes[0], leftRes[1], leftRes[2]) + min(rightRes[0], rightRes[1], rightRes[2]) + 1;
        res[1] = Math.min(leftRes[0], leftRes[2]) + Math.min(rightRes[0], rightRes[2]);
        res[2] = min(leftRes[0] + rightRes[0], leftRes[0] + rightRes[2], leftRes[2] + rightRes[0]);
        return res;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

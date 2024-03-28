package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No337 {

    // 没准儿还有一个递归加分而治之的做法
    Map<TreeNode, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        No337 no = new No337();
        // [4,1,null,2,null,3]
        no.rob(new TreeNode(
                4, new TreeNode(
                1, new TreeNode(2, new TreeNode(3), null), null), null
        ));
    }


    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;

        int[] leftRes = dfs(root.left);
        int[] rightRes = dfs(root.right);
        // 当前不选，则子节点选和不选都可以，取最值
        res[0] = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
        // 当前选，则子节点一定不能选
        res[1] = root.val + leftRes[0] + rightRes[0];
        return res;
    }

    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.get(root) != null) {
            return map.get(root);
        }

        // 根选，和根不选
        // 根选
        int sum1 = root.val;
        List<TreeNode> next = new ArrayList<>();
        if (root.left != null) {
            next.add(root.left.left);
            next.add(root.left.right);
        }
        if (root.right != null) {
            next.add(root.right.left);
            next.add(root.right.right);
        }
        for (TreeNode treeNode : next) {
            sum1 += rob2(treeNode);
        }
        // 根不选
        int sum2 = rob2(root.left) + rob2(root.right);
        int res = Math.max(sum1, sum2);
        map.put(root, res);
        return res;
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

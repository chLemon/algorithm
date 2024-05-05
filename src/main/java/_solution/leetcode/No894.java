package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

class No894 {

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if ((n & 1) == 0) {
            return res;
        }
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                continue;
            }
            List<TreeNode> leftRes = allPossibleFBT(i);
            List<TreeNode> rightRes = allPossibleFBT(n - 1 - i);
            for (TreeNode leftTree : leftRes) {
                for (TreeNode rightTree : rightRes) {
                    res.add(new TreeNode(0, leftTree, rightTree));
                }
            }
        }
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

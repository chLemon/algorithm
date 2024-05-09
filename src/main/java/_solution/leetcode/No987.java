package _solution.leetcode;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

class No987 {

    List<int[]> allNodes = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        verticalTraversal(root, 0, 0);
        allNodes.sort((n1, n2) ->
                n1[0] != n2[0]
                        ? Integer.compare(n1[0], n2[0])
                        : (n1[1] != n2[1] ? Integer.compare(n1[1], n2[1]) : Integer.compare(n1[2], n2[2])));

        int lastCol = -10001;
        List<List<Integer>> res = new ArrayList<>();
        for (int[] node : allNodes) {
            if (lastCol != node[0]) {
                res.add(new ArrayList<>());
                lastCol = node[0];
            }
            res.get(res.size() - 1).add(node[2]);
        }
        return res;
    }

    private void verticalTraversal(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        allNodes.add(new int[]{col, row, root.val});
        verticalTraversal(root.left, row + 1, col - 1);
        verticalTraversal(root.right, row + 1, col + 1);
    }

}

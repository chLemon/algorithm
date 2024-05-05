package _solution.programmercarl;

import java.util.ArrayList;
import java.util.List;

class No257 {

    public static void main(String[] args) {
        No257 no = new No257();
        no.binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3)));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backTracing(root, res, path);

        return res;
    }

    private void backTracing(TreeNode root, List<String> res, List<String> path) {
        path.add(root.val + "");

        if (root.left == null && root.right == null) {
            // 叶子节点
            res.add(String.join("->", path));
            path.remove(path.size() - 1);
            return;
        }

        if (root.left != null) {
            backTracing(root.left, res, path);
        }
        if (root.right != null) {
            backTracing(root.right, res, path);
        }
        path.remove(path.size() - 1);
    }

}

package _solution.inf;

import java.util.*;
import java.util.stream.Collectors;

class No1110 {

    Set<Integer> toDelete;

    List<TreeNode> forest = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return forest;
        if (to_delete.length == 0) {
            forest.add(root);
            return forest;
        }
        toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());

        considerToBeATree(root);

        return forest;
    }

    private void considerToBeATree(TreeNode root) {
        if (root == null) return;
        if (!toDelete.contains(root.val)) {
            forest.add(root);
            // remove
            if (root.left != null) root.left = removeNodes(root.left);
            if (root.right != null) root.right = removeNodes(root.right);
            return;
        }
        considerToBeATree(root.left);
        considerToBeATree(root.right);
    }

    private TreeNode removeNodes(TreeNode root) {
        if (toDelete.contains(root.val)) {
            considerToBeATree(root.left);
            considerToBeATree(root.right);
            return null;
        }
        if (root.left != null) root.left = removeNodes(root.left);
        if (root.right != null) root.right = removeNodes(root.right);
        return root;
    }

    public List<TreeNode> delNodes2(TreeNode root, int[] toDelete) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        Set<Integer> s = new HashSet<Integer>();
        for (int x : toDelete) s.add(x);
        if (dfs(ans, s, root) != null) ans.add(root);
        return ans;
    }

    private TreeNode dfs(List<TreeNode> ans, Set<Integer> s, TreeNode node) {
        if (node == null) return null;
        node.left = dfs(ans, s, node.left);
        node.right = dfs(ans, s, node.right);
        if (!s.contains(node.val)) return node;
        if (node.left != null) ans.add(node.left);
        if (node.right != null) ans.add(node.right);
        return null;
    }
}

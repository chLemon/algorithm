package programmercarl;

import java.util.ArrayList;
import java.util.List;

public class No145_recursion {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }

}

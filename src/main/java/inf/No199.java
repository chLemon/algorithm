package inf;

import java.util.ArrayList;
import java.util.List;

public class No199 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightSideView(root, 1);
        return res;
    }

    private void rightSideView(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > res.size()) {
            res.add(root.val);
        }
        rightSideView(root.right, depth + 1);
        rightSideView(root.left, depth + 1);
    }

}

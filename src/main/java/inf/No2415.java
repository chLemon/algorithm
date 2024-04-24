package inf;

import java.util.ArrayList;
import java.util.List;

public class No2415 {

    // 也可以用dfs，对称子树的做法

    public TreeNode reverseOddLevels(TreeNode root) {

        // 两个数组
        int num = 0;
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        List<TreeNode> nxt = new ArrayList<>();

        while (cur.size() > 0) {
            // 当前层不为空，先填充下一层
            for (TreeNode node : cur) {
                if (node.left != null) nxt.add(node.left);
                if (node.right != null) nxt.add(node.right);
            }

            if ((num & 1) == 1) {
                // 奇数层，需要交换值
                int left = 0;
                int right = cur.size() - 1;
                while (left < right) {
                    TreeNode lNode = cur.get(left);
                    TreeNode rNode = cur.get(right);

                    int v = lNode.val;
                    lNode.val = rNode.val;
                    rNode.val = v;

                    left++;
                    right--;
                }
            }

            cur = nxt;
            nxt = new ArrayList<>();
            num++;
        }
        return root;
    }

}

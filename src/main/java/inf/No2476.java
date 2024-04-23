package inf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2476 {

    List<Integer> inorder = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        // 中序遍历，得到二叉树数组，然后二分查找填充答案
        inorderRoot(root);

        List<List<Integer>> res = new ArrayList<>();
        for (Integer query : queries) {
            // 大于等于的最小值下标
            int maxIndex = binarySearch(query);
            if (maxIndex < inorder.size() && inorder.get(maxIndex).equals(query)) {
                res.add(Arrays.asList(query, query));
            } else {
                res.add(Arrays.asList(maxIndex - 1 >= 0 ? inorder.get(maxIndex - 1) : -1,
                        maxIndex < inorder.size() ? inorder.get(maxIndex) : -1));
            }
        }

        return res;
    }

    private void inorderRoot(TreeNode root) {
        if (root == null) return;
        inorderRoot(root.left);

        inorder.add(root.val);

        inorderRoot(root.right);
    }

    private int binarySearch(int value) {
        int left = 0;
        int right = inorder.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            Integer midValue = inorder.get(mid);
            if (midValue < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}

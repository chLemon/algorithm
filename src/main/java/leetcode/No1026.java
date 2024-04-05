package leetcode;

import java.util.SortedMap;
import java.util.TreeMap;

public class No1026 {


    int res = Integer.MIN_VALUE;

    public int maxAncestorDiff2(TreeNode root) {
        dfs2(root, root.val, root.val);
        return res;
    }

    // 利用局部变量来实现回溯
    private void dfs2(TreeNode root, int min, int max) {
        if (root == null) {
            res = Math.max(res, max - min);
            return;
        }
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        dfs2(root.left, min, max);
        dfs2(root.right, min, max);
    }

    public int maxAncestorDiff(TreeNode root) {
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        dfs(root, sortedMap);
        return res;
    }

    private void dfs(TreeNode root, SortedMap<Integer, Integer> sortedMap) {
        // 访问root
        int value = root.val;
        sortedMap.put(value, sortedMap.getOrDefault(value, 0) + 1);
        if (sortedMap.keySet().size() > 1) {
            res = Math.max(res, Math.abs(sortedMap.firstKey() - sortedMap.lastKey()));
        }
        // 递归访问剩下的节点
        if (root.left != null) {
            dfs(root.left, sortedMap);
            if (sortedMap.get(root.left.val) > 1) {
                sortedMap.put(root.left.val, sortedMap.get(root.left.val) - 1);
            } else {
                sortedMap.remove(root.left.val);
            }
        }
        if (root.right != null) {
            dfs(root.right, sortedMap);
            if (sortedMap.get(root.right.val) > 1) {
                sortedMap.put(root.right.val, sortedMap.get(root.right.val) - 1);
            } else {
                sortedMap.remove(root.right.val);
            }
        }
    }

    public class TreeNode {
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

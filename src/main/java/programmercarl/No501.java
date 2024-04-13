package programmercarl;

import java.util.ArrayList;
import java.util.List;

public class No501 {

    Integer last = null;
    int count = 0;
    int maxCount = 0;
    List<Integer> mode = new ArrayList<>();


    // 不使用额外空间的话，中序遍历，记录当前数字的数量，更新记录众数
    public int[] findMode(TreeNode root) {
        dfs(root);
        return mode.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        
        if (last == null || last != root.val) {
            count = 1;
        } else {
            count++;
        }
        if (maxCount == count) {
            mode.add(root.val);
        } else if (maxCount < count) {
            maxCount = count;
            mode.clear();
            mode.add(root.val);
        }
        last = root.val;

        dfs(root.right);
    }

}

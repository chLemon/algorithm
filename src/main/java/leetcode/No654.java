package leetcode;

class No654 {

    public static void main(String[] args) {
        No654 no = new No654();
        no.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

    /*
    给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:

    创建一个根节点，其值为 nums 中的最大值。
    递归地在最大值 左边 的 子数组前缀上 构建左子树。
    递归地在最大值 右边 的 子数组后缀上 构建右子树。
    返回 nums 构建的 最大二叉树 。
     */

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        if (end - start == 1) {
            return new TreeNode(nums[start]);
        }
        int maxIndex = maxIndex(nums, start, end);
        return new TreeNode(nums[maxIndex],
                constructMaximumBinaryTree(nums, start, maxIndex),
                constructMaximumBinaryTree(nums, maxIndex + 1, end));
    }

    private int maxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        int max = nums[start];
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
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

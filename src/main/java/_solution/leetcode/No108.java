package _solution.leetcode;

class No108 {

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

    public static void main(String[] args) {
        No108 no = new No108();
        TreeNode node = no.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (end <= start) {
            return null;
        }
        if (end - start == 1) {
            return new TreeNode(nums[start]);
        }
        int mid = start + (end - start) / 2;
        return new TreeNode(nums[mid],
                sortedArrayToBST(nums, start, mid),
                sortedArrayToBST(nums, mid + 1, end));
    }
}

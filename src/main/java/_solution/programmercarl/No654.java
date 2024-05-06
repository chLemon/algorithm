package _solution.programmercarl;

import domain.TreeNode;

class No654 {

    public static void main(String[] args) {
        No654 no = new No654();
        no.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);

        int maxIndex = findMaxIndex(nums, start, end);
        return new TreeNode(nums[maxIndex],
                constructMaximumBinaryTree(nums, start, maxIndex - 1),
                constructMaximumBinaryTree(nums, maxIndex + 1, end));
    }

    private int findMaxIndex(int[] nums, int start, int end) {
        int max = -1;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

}

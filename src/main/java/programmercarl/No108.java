package programmercarl;

public class No108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);
        int mid = start + (end - start) / 2;
        return new TreeNode(nums[mid],
                sortedArrayToBST(nums, start, mid - 1),
                sortedArrayToBST(nums, mid + 1, end));
    }

}

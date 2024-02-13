package tree;

public class ConvertSortedArraytoBinarySearchTree {
    private TreeNode makeTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeTree(nums, start, mid - 1);
        root.right = makeTree(nums, mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length - 1);
    }
}

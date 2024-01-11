package tree;

public class MaximumDifferenceBetweenNodeandAncestor {
    private int max_diff = 0;

    private void trace(TreeNode root, int smallestSoFar, int largestSoFar) {
        if (root == null) {
            return;
        }
        int currMaxDiff = Math.max(Math.abs(root.val - smallestSoFar), Math.abs(root.val - largestSoFar));
        max_diff = Math.max(max_diff, currMaxDiff);
        smallestSoFar = Math.min(smallestSoFar, root.val);
        largestSoFar = Math.max(largestSoFar, root.val);
        trace(root.left, smallestSoFar, largestSoFar);
        trace(root.right, smallestSoFar, largestSoFar);
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        trace(root, root.val, root.val);
        return max_diff;

    }
}

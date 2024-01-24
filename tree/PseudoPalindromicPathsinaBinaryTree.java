package tree;

public class PseudoPalindromicPathsinaBinaryTree {
    private int noOfPaths;

    private void findPaths(TreeNode root, int[] digits) {
        // if null
        if (root == null) {
            return;
        }
        digits[root.val] += 1;
        // if leaf found
        if (root.left == null && root.right == null) {
            // check if less than 1 odd occ
            int odds = 0;
            for (int i = 0; i < 10; i++) {
                if (digits[i] % 2 != 0) {
                    odds += 1;
                }
            }
            if (odds <= 1) {
                this.noOfPaths += 1;
            }
        }

        findPaths(root.left, digits);
        findPaths(root.right, digits);
        digits[root.val] -= 1;


    }

    public int pseudoPalindromicPaths(TreeNode root) {
        this.noOfPaths = 0;
        int[] digits = new int[10];
        findPaths(root, digits);
        return this.noOfPaths;
    }
}

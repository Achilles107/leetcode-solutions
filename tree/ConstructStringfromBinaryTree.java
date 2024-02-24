package tree;

public class ConstructStringfromBinaryTree {
    private StringBuilder result;

    private void makeString(TreeNode t) {
        if (t == null) {
            return;
        }

        result.append(t.val);
        result.append('(');

        if (t.left == null && t.right == null) {
            result = result.deleteCharAt(result.length() - 1);
            return;
        }
        makeString(t.left);

        result.append(')');
        if (t.right != null) {
            result.append('(');
            makeString(t.right);
            result.append(')');
        }


    }

    public String tree2str(TreeNode t) {
        result = new StringBuilder();
        makeString(t);
        return result.toString();
    }
}

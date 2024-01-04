package tree;

public class DeleteNodeinaBST {

    private TreeNode leftMost = null;
    private final TreeNode[] treeNode = new TreeNode[2];

    private void findNodeTobeDeleted(TreeNode parent, TreeNode root, int key) {
        if (root == null) {
            return;
        }
        if (root.val == key) {
            treeNode[0] = parent;
            treeNode[1] = root;
            return;
        }
        findNodeTobeDeleted(root, root.left, key);
        findNodeTobeDeleted(root, root.right, key);
    }

    private void leftMostNode(TreeNode root) {
        if (root == null) {
            return;
        }
        leftMost = root;
        leftMostNode(root.left);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        findNodeTobeDeleted(null, root, key);
        TreeNode parent = treeNode[0];
        TreeNode nodeToDel = treeNode[1];

        // node not found
        if (nodeToDel == null) {
            return root;
        }

        // node is root
        if (parent == null) {
            leftMostNode(nodeToDel.right);
            if (leftMost == null) {
                leftMostNode(nodeToDel.left);
                if (leftMost == null) {
                    return null;
                } else {
                    return nodeToDel.left;
                }
            } else {
                if (nodeToDel.right != null) {
                    leftMost.left = nodeToDel.left;
                    return nodeToDel.right;
                }
            }
        }

        // node is not root and has two children
        if (nodeToDel.left != null && nodeToDel.right != null) {
            // find the leftmost node (L) from right subtree starting at nodeToDel
            // attach the left subtree to the left of L
            // attach nodeToDel.right to parent
            leftMostNode(nodeToDel.right);
            if (nodeToDel.val < parent.val) {
                leftMost.left = nodeToDel.left;
                parent.left = nodeToDel.right;
            } else {
                leftMost.left = nodeToDel.left;
                parent.right = nodeToDel.right;
            }

        }
        // node has only left child
        else if (nodeToDel.left != null) {
            if (parent.left == nodeToDel) { // node is in the left subtree
                parent.left = nodeToDel.left;
                nodeToDel.left = null;
            } else { // node is in the right subtree
                parent.right = nodeToDel.left;
                nodeToDel.left = null;
            }
        } else { // node has only right child
            if (parent.left == nodeToDel) { // node is in the left subtree
                parent.left = nodeToDel.right;
                nodeToDel.right = null;
            } else { // node is in the right subtree
                parent.right = nodeToDel.right;
                nodeToDel.right = null;
            }
        }
        return root;
    }
}

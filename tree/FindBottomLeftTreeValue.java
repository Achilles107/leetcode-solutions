package tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int lastLeftMost = -1;

        Queue<TreeNode> treeNodes = new LinkedList<>();

        treeNodes.add(root);

        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            TreeNode currNode = null;
            for (int i =0; i<size; i++) {
                currNode = treeNodes.poll();
                if (currNode.right != null) {
                    treeNodes.add(currNode.right);
                }
                if (currNode.left != null) {
                    treeNodes.add(currNode.left);
                }
            }
            lastLeftMost = currNode.val;
        }
        return lastLeftMost;
    }
    public static void main(String[] args) {

    }
}

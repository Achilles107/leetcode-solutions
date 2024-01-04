package tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    private void traverseTillLeaf(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        traverseTillLeaf(root.left, leaves);
        traverseTillLeaf(root.right, leaves);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        traverseTillLeaf(root1, list1);
        traverseTillLeaf(root2, list2);

        int size = Math.min(list1.size(), list2.size());
        int i;
        for (i = 0; i < size; i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return i == list1.size() && i == list2.size();
    }
}

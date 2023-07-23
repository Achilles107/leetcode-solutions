package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeinBinarySearchTree {

    Map<Integer, Integer> countVals = new HashMap<>();

    public int[] findMode(TreeNode root) {
        search(root);
        int max_count = 0;
        for (int key: countVals.keySet()) {
            max_count = Math.max(max_count, countVals.get(key));
        }
        int sizeOfresult = 0;
        for (int key: countVals.keySet()) {
            if (countVals.get(key) == max_count)
                sizeOfresult++;
        }
        int res[] = new int[sizeOfresult];
        int i =0;
        for (int key: countVals.keySet()) {
            if (countVals.get(key) == max_count)
                res[i++] = key;
        }
        return res;
    }

    private void search(TreeNode root) {
        if (root == null)
            return;
        countVals.put(root.val, countVals.getOrDefault(root.val, 0) + 1);
        search(root.left);
        search(root.right);
    }
    public static void main(String[] args) {

    }
}

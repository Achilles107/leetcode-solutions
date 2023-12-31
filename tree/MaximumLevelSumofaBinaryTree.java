package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumofaBinaryTree {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int minLevel = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level += 1;
            int sum = 0;
            for (int i =0; i<size; i++) {
                TreeNode currNode = queue.poll();
                sum += currNode.val;
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            if (maxSum < sum) {
                maxSum = sum;
                minLevel = level;
            }
        }
        return minLevel;
    }
}
